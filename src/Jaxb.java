//xjc.exe -d src/ D:\JAVA\java-lab6\osm.xsd

import generated.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class Jaxb {
    Osm osm;
    Set<String> busstopSet = new TreeSet<>();
    Map<String, StreetData> streetMap = new TreeMap<String, StreetData>();


    public void unmarshall() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance("generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        osm = (Osm) unmarshaller.unmarshal(new File("UfaCenter.xml"));
        List lst = osm.getBoundOrUserOrPreferences();
        //osm.
        int i = 0;
        for (Object p : lst) {
            boolean vBusStop = false;
            String busStopName = "";
            String highway = "";
            String streetName = "";


            //if (p.getClass()== Node.class) {
            if (p instanceof Node) {
                i++;
//                System.out.println(i + "***********************************************");
                Node node = (Node) p;
                for (Tag tag : node.getTag()) {
                    if (tag.getK().equals("highway") && tag.getV().equals("bus_stop")) {
                        vBusStop = true;

                    }
                    if (tag.getK().equals("name")) {
                        busStopName = tag.getV();
                        //  System.out.println(busStopName);
                        // System.out.println(vBusStop);
                    }
                    if (vBusStop && busStopName != "") {

                        //System.out.println(busStopName);

                        busstopSet.add(busStopName);
                        // break;
                    }
                    //System.out.println(tag.toString() + "; " + tag.getK() + "=" +tag.getV() );
                }
//                System.out.println("vBusStop="+vBusStop);
//                System.out.println("***********************************************");
            }
            if (p instanceof Way) {
                Way way = (Way) p;
                for (Object oWay : way.getRest()) {
                    if (oWay instanceof Tag) {
                        Tag tag = (Tag) oWay;
                        if (((Tag) oWay).getK().equals("highway")) {
                            highway = ((Tag) oWay).getV();
                        }
                        if (((Tag) oWay).getK().equals("name")) {
                            streetName = ((Tag) oWay).getV();

                            if (streetName != "" && highway != "") {
                                if (streetMap.containsKey(streetName)) {
                                    streetMap.get(streetName).addHighway(highway);
                                } else {
                                    streetMap.put(streetName, new StreetData(streetName, highway));
                                }
                            }


                        }
                    }

                    //System.out.println(tag.toString() + "; " + tag.getK() + "=" +tag.getV() );
                }
//                System.out.println("vBusStop="+vBusStop);
//                System.out.println("***********************************************");
            }
        }

        System.out.println(busstopSet.toString());
        for (Map.Entry<String, StreetData> entry : streetMap.entrySet()) {
            System.out.print(entry.getValue().name);
            System.out.print("\t\t\t\t\t");
            System.out.print(entry.getValue().highways.size());
            System.out.print("\t\t");
            System.out.println(entry.getValue().highways);
            //System.out.println(entry.getValue().name + "\t\t\t\t\t\t" + entry.getValue().highways.size()+"\t\t\t " + entry.getValue().highways);
        }

//            else {
//                System.out.print(p + " " + p.getClass());
//                System.out.println();
//            }
    }


}