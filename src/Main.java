import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        WorkXml readerXml = new WorkXml();
        Document document = readerXml.reader("clouds.svg");
        Element element = document.getDocumentElement();
        NodeList nodeList = document.getChildNodes();
       // readerXml.printCircles(element.getChildNodes());

       // System.out.println(document.getDocumentElement().getTagName());
// Получаем корневой элемент
//        Node root = document.getDocumentElement();
//        System.out.println(root);
        //readerXml.printElements(document);
        readerXml.viewDocument(document);

        // Просматриваем все подэлементы корневого - т.е. книги
//        NodeList books = root.getChildNodes();
//        for (int i = 0; i < books.getLength(); i++) {
//            Node book = books.item(i);
//            // Если нода не текст, то это книга - заходим внутрь
//            if (book.getNodeType() != Node.TEXT_NODE) {
//                NodeList bookProps = book.getChildNodes();
//                for(int j = 0; j < bookProps.getLength(); j++) {
//                    Node bookProp = bookProps.item(j);
//                    // Если нода не текст, то это один из параметров книги - печатаем
//                    if (bookProp.getNodeType() != Node.TEXT_NODE) {
//                        System.out.println(bookProp.getNodeName() + ":" + bookProp.getChildNodes().item(0).getTextContent());
//                    }
//                }
//                System.out.println("===========>>>>");
//            }
//        }



//        readerXml.addTag(document);
//        Element el2 = document.createElement("svg");
//        el2.appendChild(element1);


//        readerXml.printCircles(element.getChildNodes(), "circle");
//        readerXml.printCircles(element.getChildNodes(), "polyline");
//readerXml.writeAttr(element,"polyline", "red");
readerXml.saveDemo(document);

//readerXml.printCirclesList();
    }


}