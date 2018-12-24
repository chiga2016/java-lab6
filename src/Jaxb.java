//xjc.exe -d src/ D:\JAVA\java-lab6\osm.xsd

import generated.Osm;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Jaxb{
    Osm osm;
    List<String> busstopList = new ArrayList<String>();



    public void unmarshall() throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance("generated");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        osm = (Osm) unmarshaller.unmarshal(new File("UfaCenter.xml"));
        List lst = osm.getBoundOrUserOrPreferences();
lst.stream()
        .forEach(p-> System.out.println(p.getClass().));


    }



}