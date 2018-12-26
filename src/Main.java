import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException, JAXBException {
        WorkXml readerXml = new WorkXml();
        Document document = readerXml.reader("clouds.svg");
       // Element element = document.getDocumentElement();
//        NodeList nodeList = document.getChildNodes();
//
//        readerXml.viewDocument(document);
//        readerXml.insertCircle();
//        readerXml.saveDemo(document);
//     new Stax.StaxDemo().schemaCheckerTest("UfaCenter.xml", "osm.xsd");

     //new Stax.StaxDemo().readStaxEvent("UfaCenter.xml");

    new Jaxb().unmarshall();


    }


}