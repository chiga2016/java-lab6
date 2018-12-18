import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        WorkXml readerXml = new WorkXml();
        Document document = readerXml.reader("demo.svg");
        Element element = document.getDocumentElement();
        readerXml.printCircles(element.getChildNodes());

        System.out.println(document.getDocumentElement().getTagName());

        readerXml.addTag(document);
//        Element el2 = document.createElement("svg");
//        el2.appendChild(element1);


//        readerXml.printCircles(element.getChildNodes(), "circle");
//        readerXml.printCircles(element.getChildNodes(), "polyline");
//readerXml.writeAttr(element,"polyline", "red");
readerXml.saveDemo(document);

//readerXml.printCirclesList();
    }


}