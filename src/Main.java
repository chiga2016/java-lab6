import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        WorkXml readerXml = new WorkXml();
//        Document document = readerXml.reader("clouds.svg");
//        Element element = document.getDocumentElement();
//        NodeList nodeList = document.getChildNodes();
//        readerXml.saveDemo(document);

        new Stax.StaxDemo().readStaxStream("UfaCenterSmall.xml");
        new Stax.StaxDemo().writeStaxExample();

    }


}