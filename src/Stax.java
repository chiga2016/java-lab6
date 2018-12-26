import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Stax {


    public static class StaxDemo {


        void readStaxEvent(String filename) throws XMLStreamException, FileNotFoundException {
            //List lst = new ArrayList();
            Set<String> busStopSet = new TreeSet<>();
            Map<String, StreetData> streetMap = new TreeMap<String, StreetData>();
//            int numberLineBusStation=0;
//            int currentLineNumber=0;
//            int nextTagNumber;
//            String nextStartEl = "";
            boolean vNode;
            boolean vBusStope;
            String busStopName;
            try {
                XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
                XMLStreamReader eReader = xmlInputFactory.createXMLStreamReader(new FileReader(filename));
                while (eReader.hasNext()) {
                    vNode = false;
                    //vBusStope=false;
                    //busStopName="";

                    int e = eReader.next();
                    if (e == XMLEvent.START_ELEMENT && eReader.getLocalName().equals("node")) {
                        vNode = true;
                        vBusStope = false;
                        busStopName = "";
                        while (vNode) {
                            int ee = eReader.next();
                            if (ee == XMLEvent.END_ELEMENT && eReader.getLocalName().equals("node")) {
                                vNode = false;
                            }
                            if (ee == XMLEvent.START_ELEMENT && eReader.getLocalName().equals("tag")) {
                                String k = eReader.getAttributeValue("", "k");
                                String v = eReader.getAttributeValue("", "v");
//                           String v = ee.asStartElement().getAttributeByName(new QName("v")).getValue();
//                           System.out.println(eReader.getLocalName());
//                          while( ee.asStartElement().getAttributes().hasNext())
//                          {
//                              //System.out.println(ee.asStartElement().getAttributes().next());
//                          }

                                if (v.equals("bus_stop")) {
                                    vBusStope = true;
                                }
                                if (k.equals("name")) {
                                    busStopName = eReader.getAttributeValue(1);
                                }
                            }
                        }
                        if (vBusStope && busStopName != null) {
                            busStopSet.add(busStopName);
                        }
                    } //node
                    boolean vWay = false;
                    boolean vTag = false;
                    String highway = "";
                    String streetName = "";
                    int wayNumber = 0;
                    if (e == XMLEvent.START_ELEMENT && eReader.getLocalName().equals("way")) {

                        // System.out.println("way вошли");
                        vWay = true;
                        while (vWay) {
                            wayNumber++;
                            //System.out.print(eReader.getLocation().getLineNumber());
                            //System.out.println(" - way true");
                            int ee = eReader.next();
                            if (ee == XMLEvent.START_ELEMENT && eReader.getLocalName().equals("tag")) {
                                // System.out.println("нашелся tag");
                                //System.out.println(eReader.getAttributeCount());
                                //System.out.printf("%s == 0: %s, 1: %s, 2: %s, 3: %s ",eReader.getLocalName(), eReader.getAttributeValue(0), eReader.getAttributeValue(1), eReader.getAttributeValue(2), eReader.getAttributeValue(3));

                                String str = eReader.getAttributeValue(0);
                                //System.out.println(eReader.getLocalName());
                                //System.out.println(str);
                                if (str.equals("highway")) {
                                    highway = eReader.getAttributeValue(1);

                                } else if (str.equals("name")) {
                                    streetName = eReader.getAttributeValue(1);
                                }
                            }
                            if (ee == XMLEvent.END_ELEMENT && eReader.getLocalName().equals("way")) {
                                //System.out.print(eReader.getLocation().getLineNumber());
                                // System.out.println(" - вышли из way");
                                //System.out.println();
                                vWay = false;
                            }
                        }

                        if (highway != "" && streetName != "") {
                            //System.out.println("highway="+highway+""+"; streetName="+streetName);
                            if (streetMap.containsKey(streetName)) {
                                streetMap.get(streetName).addHighway(highway);
                            } else streetMap.put(streetName, new StreetData(streetName, highway));
                        }


                    }
                }
                System.out.println(busStopSet.toString());
                System.out.println("Список улиц");
                for (Map.Entry<String, StreetData> entry : streetMap.entrySet()) {
                    System.out.print(entry.getValue().name);
                    System.out.print("\t\t\t\t\t");
                    System.out.print(entry.getValue().highways.size());
                    System.out.print("\t\t");
                    System.out.println(entry.getValue().highways);
                    //System.out.println(entry.getValue().name + "\t\t\t\t\t\t" + entry.getValue().highways.size()+"\t\t\t " + entry.getValue().highways);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (XMLStreamException ex) {
                ex.printStackTrace();
            }
        }

        // простая проверка схемы
        void schemaCheckerTest(String fileName, String schemaName) {
            try {
                SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = factory.newSchema(new File(schemaName));
                Validator validator = schema.newValidator();
                validator.validate(new StreamSource(new File(fileName)));
                System.out.printf("Файл %s соответствует схеме %s", fileName, schemaName);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        void writeStaxExample() {
            XMLOutputFactory xof
                    = XMLOutputFactory.newFactory();

            try {
                XMLStreamWriter sw2
                        = xof.createXMLStreamWriter(System.err);
                XMLStreamWriter sw = sw2;//new IndentingXMLStreamWriter(sw2); // only for older JDKs

                sw.writeStartDocument();
                sw.writeStartElement("hello");
                sw.writeAttribute("a", "2");
                sw.writeAttribute("b", "3&<>&");
                sw.writeCharacters("\nsome text \"\"<b> ");
                sw.writeEmptyElement("emptyElement");
                sw.writeEndElement();
                sw.writeEndDocument();

                sw.close();
            } catch (XMLStreamException ex) {
                ex.printStackTrace();
            }


        }


    }

}
