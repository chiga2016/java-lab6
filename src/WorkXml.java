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
        return document;
    }


//    void printCircles(NodeList nodeList) {
//        //NodeList nodeList = element.getChildNodes();
//
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            if (nodeList.item(i) instanceof Element)
//                if (((Element) nodeList.item(i)).getTagName().equals("circle")) {
//                    System.out.println(((Element) nodeList.item(i)).getTagName());
//                    circles.add(new Circle(
//                            nodeList.item(i).getAttributes().getNamedItem("cx").getNodeValue(),
//                            nodeList.item(i).getAttributes().getNamedItem("cy").getNodeValue(),
//                            nodeList.item(i).getAttributes().getNamedItem("r").getNodeValue(),
//                            nodeList.item(i).getAttributes().getNamedItem("stroke").getNodeValue(),
//                            nodeList.item(i).getAttributes().getNamedItem("stroke-width").getNodeValue(),
//                            nodeList.item(i).getAttributes().getNamedItem("fill").getNodeValue()));
//                }
//        }
//    }
//
//    void printCirclesList() {
//        circles.stream().forEach(p -> {
//                    System.out.println(p);
//                }
//        );
//    }

    void viewDocument(Document doc) {
        Node n = doc.getDocumentElement();
       // lookAttrs(n);
        lookChildren(n,0);
    }


    private void lookAttrs(Node n) {
       //NodeList nl=n.getChildNodes();
        NamedNodeMap attrs = n.getAttributes();
        if (attrs==null) return;
        int num = attrs.getLength();
        if (num==0) return;
        Node curNode;
        System.out.print("[");
        for (int i=0;i<num;i++) {
            curNode = attrs.item(i);
            System.out.printf("%s=%s ",
                    curNode.getNodeName(),
                    curNode.getNodeValue());
        }
        System.out.printf("]\n");
    }

    void changeColor (Node node, String fill){
        Node parentNode = node.getParentNode();
        if (node.getAttributes().getNamedItem("style")!=null){
            String fillStyle = "fill:" + fill+"; fill-rule: evenodd; stroke: #555; opacity: 0; stroke-width: 1px; stroke-linecap: butt; stroke-linejoin: miter; stroke-opacity: 1;";
            ((Element)node).setAttribute("style",fillStyle);
        }
        else {
//            if (node.getAttributes().getNamedItem("fill")==null&&parentNode.getAttributes().getNamedItem("fill")!=null ) {
//                ((Element)parentNode).setAttribute("fill",fill);
//            }
//            else {
                ((Element)node).setAttribute("fill", fill);
//            }
        }
    }


    private void lookChildren(Node n, int level) {
        NodeList nl=n.getChildNodes();//потомки
        String space = "                                         ".substring(0,level);
        int num = nl.getLength(); //количество потомков
        Node curNode;
        Node parentCurNode;
        for (int i=0;i<num;i++) {
            curNode = nl.item(i);
            parentCurNode = nl.item(i).getParentNode();
                //  System.out.println(curNode.getNodeType());
                // curNode.getNodeValue() -- значение, существует для типов
                // ATTRIBUTE, COMMENT, CDATA, TEXT
                // curNode.getNodeName() -- имя тега для ELEMENT
                // "#text" - для TEXT, "#cdata-section", "#comment","#document"
                // "#document-fragment"
                //System.out.printf("%s---%s\n",curNode.getNodeName(),curNode.getNodeValue());
                // в зависимости от типа элемента...
                switch (curNode.getNodeType()) {
                    case Node.ELEMENT_NODE:

                        if (curNode.getNodeName().equals("circle")) {
                           // ((Element)curNode).setAttribute("stroke", "black"); // заменяем атрибут
                            //((Element)curNode).setAttribute("fill", "red");
                            insertCircle(curNode);
                            changeColor(curNode,"black");
                            System.out.printf(space + "ELEMENT: <%s> - Parent = <%s>\n", curNode.getNodeName(),parentCurNode.getNodeName());
                            // читаем атрибуты
                            System.out.print(space);
                            lookAttrs(curNode);
                        }
                        if (curNode.getNodeName().equals("rect")) {
                            changeColor(curNode,"green");
                            //System.out.printf(space + "ELEMENT: <%s> - Parent = <%s>\n", curNode.getNodeName(),parentCurNode.getNodeName());
                            // читаем атрибуты
                            System.out.print(space);
                            //lookAttrs(curNode);
                        }
                        if (curNode.getNodeName().equals("path")) {
                            changeColor(curNode,"brown");
                            //System.out.printf(space + "ELEMENT: <%s> - Parent = <%s>\n", curNode.getNodeName(),parentCurNode.getNodeName());
                            // читаем атрибуты
                            System.out.print(space);
                            //lookAttrs(curNode);
                        }
                        // рекурсивно просматриваем вложенные узлы
                        lookChildren(curNode, level + 5);
                        break;
                    case Node.COMMENT_NODE:
                        // печатаем комментарий
                        //System.out.println(space + "COMMENT: " + curNode.getNodeValue());
                        break;
                    case Node.TEXT_NODE:
                        // печатаем текст, если он не только из пробелов и переводов строк
                        String txt = curNode.getNodeValue().trim();
//                    if (txt.length()>0) System.out.println(space+"TEXT: "+txt);
//                    else System.out.println(space+" EMPTY TEXT");
                        break;
                }
            }
        }



    void insertCircle(Node node) {
        Node parentNode = node.getParentNode();
        Node cloneNode = node.cloneNode(true);
        ((Element)cloneNode).setAttribute("r","10");
        ((Element)cloneNode).setAttribute("fill","white");
        ((Element)cloneNode).setAttribute("stroke","red");
        ((Element)cloneNode).setAttribute("stroke-width","2");
        parentNode.appendChild(cloneNode);

    }

    void saveDemo(Document doc) throws IOException {

        Result sr = new StreamResult(new FileWriter("clouds2.svg"));
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