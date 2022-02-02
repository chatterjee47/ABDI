package testUtility;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLFileReader {
	
	public static Node node;
	public static Document doc;
	public static String username;
	public static String firstname;
	public static String lastname;
	public static String zipcode;
	public static String message;

	public static void XMLRead(int value) throws ParserConfigurationException, SAXException, IOException {
		
			String filePath = "D:\\AditTeacherOn\\CucumberBDDProject-main\\CucumberBDDProject-main\\CleverMediaCucumberProject\\src\\test\\resources\\Data\\Data.xml";
			File file = new File(filePath);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("user");
			int tLength = nodeList.getLength();
			System.out.println(tLength);
			
				node = nodeList.item(value);
				if(node.getNodeType()==Node.ELEMENT_NODE){
					Element element = (Element)node;
					username = element.getAttribute("acn");
					firstname=element.getElementsByTagName("firstname").item(0).getTextContent();
					lastname=element.getElementsByTagName("lastname").item(0).getTextContent();
					zipcode=element.getElementsByTagName("zipcode").item(0).getTextContent();
					message=element.getElementsByTagName("message").item(0).getTextContent();
				
				}
	}
}