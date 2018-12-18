import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WorkXml {

    List<Circle> circles = new ArrayList<Circle>();

    Document reader(String name) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(name);

        //Element element = document.getDocumentElement();
        // System.out.println(element.getTagName());
        //printCircles(element.getChildNodes());
        return document;
    }




     void printCircles(NodeList nodeList) {
        // NodeList nodeList = element.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element)
                if (((Element) nodeList.item(i)).getTagName().equals("circle")) {
                    System.out.println(((Element) nodeList.item(i)).getTagName());
                    circles.add(new Circle(
                            nodeList.item(i).getAttributes().getNamedItem("cx").getNodeValue(),
                            nodeList.item(i).getAttributes().getNamedItem("cy").getNodeValue(),
                            nodeList.item(i).getAttributes().getNamedItem("r").getNodeValue(),
                            nodeList.item(i).getAttributes().getNamedItem("stroke").getNodeValue(),
                            nodeList.item(i).getAttributes().getNamedItem("stroke-width").getNodeValue(),
                            nodeList.item(i).getAttributes().getNamedItem("fill").getNodeValue()));
                }
        }
    }

    void printCirclesList() {
        circles.stream().forEach(p -> {
                    System.out.println(p);
                }
        );
    }


    void printElements(NodeList nodeList, String typeElement) {
        // NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element)
                if (((Element) nodeList.item(i)).getTagName() == typeElement) {
                    System.out.println(((Element) nodeList.item(i)).getTagName());
                if (nodeList.item(i).hasChildNodes()){
                    printElements(nodeList.item(i).getChildNodes(),"");
                }
                }
        }
    }


    // меняем цвета линий
    void writeAttr(Element element, String typeElement, String str) {
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            if (element.getChildNodes().item(i) instanceof Element)
                if (((Element) element.getChildNodes().item(i)).getTagName() == typeElement) {
                    System.out.println(((Element) element.getChildNodes().item(i)).getTagName());
                    //System.out.println(element.getChildNodes().item(i).getAttributes().getNamedItem("style"));
                    System.out.println(element.getChildNodes().item(i).getAttributes().getNamedItem("style").getNodeValue());
                    ((Element) element.getChildNodes().item(i)).setAttribute("style", "fill:white;stroke:black;stroke-width:5");
                    System.out.println(element.getChildNodes().item(i).getAttributes().getNamedItem("style").getNodeValue());


                }
        }
    }

    void addTag (Document doc)
    {
        Element element = doc.getDocumentElement();
//        Element element1 = doc.createElement(name);
//        Text idValue = doc.createTextNode(text);
int lenElement=element.getChildNodes().getLength();
for (int i=0;i<lenElement; i++)
{
    if (element.getChildNodes().item(i) instanceof Element)
    if (((Element) element.getChildNodes().item(i)).getTagName().equals("circle")){
        Element elementClone = (Element) element.getChildNodes().item(i).cloneNode(true);
        elementClone.setAttribute("r","5");
        elementClone.setAttribute("fill","white");
        elementClone.setAttribute("stroke","red");
        System.out.println(elementClone.toString());
        System.out.println(element.getChildNodes().getLength());

        // element.appendChild(elementClone);

       element.insertBefore(elementClone,((Element) element.getChildNodes().item(i)));

        // System.out.println(element.getChildNodes().item(i));
       // System.out.println(element.getChildNodes().item(i).cloneNode(true));
    }
          //  System.out.println(element.getChildNodes().item(i));
   // element.insertBefore(element.getChildNodes().item(i).,el)
}

//        element.appendChild(element1);
//        element1.appendChild(idValue);
        //Element newElement = doc.createElement(stepType); // Element to be inserted
        //newElement.setAttribute("name", stepName);
       // elem.getParentNode().insertBefore(newElement, elem.getNextSibling());
    }
    void saveDemo(Document doc) throws IOException {

        Result sr = new StreamResult(new FileWriter("demo2.svg"));
        Result sr2 = new StreamResult(System.out);
        DOMSource domSource = new DOMSource(doc);

//        Node totalNode = doc.createTextNode("testtesttest");
//        Element totalElement = doc.createElement("total");
//        totalElement.appendChild(totalNode);




        //  DOMSource domSource = new DOMSource(i2);
        // в newTransformer() можно было бы передать xslt - преобразование
        Transformer tr;
        try {
            tr = TransformerFactory
                    .newInstance()
                    .newTransformer();

            // настройки "преобразования"
            tr.setOutputProperty(
                    OutputKeys.OMIT_XML_DECLARATION, "yes");
            tr.setOutputProperty(
                    OutputKeys.INDENT, "yes"); // отступы

            tr.transform(domSource, sr ); // в файл
            //tr.transform(domSource, sr2 ); // на экран
        } catch (TransformerException ex) {
            System.out.println(ex.getMessage());
            // Logger.getLogger(DomTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        // tr.transform(schemaSrc, sr2 ); // а теперь схему на экран
    }

}