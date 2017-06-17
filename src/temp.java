import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class temp {

   public static void main(String argv[]) throws Exception {

	   FileInputStream fis = new FileInputStream("C:\\Java Workspace\\Automation_Android_application\\Excel.xlsx");
	   XSSFWorkbook wh = new XSSFWorkbook("C:\\Java Workspace\\Automation_Android_application\\Excel.xlsx");
	   XSSFSheet mySheet = wh.getSheetAt(0);
	   XSSFRow row;
	    XSSFCell cell;
	    row = mySheet.getRow(1);
	    
	   row.createCell(0).setCellValue("Jaydeep");
	   FileOutputStream fileOut = new FileOutputStream("C:\\Java Workspace\\Automation_Android_application\\Excel.xlsx");
	    wh.write(fileOut);
	    fileOut.close();
	   /*
	   
	   <company>
	   <staff id="1001">
	       <firstname>yong</firstname>
	       <lastname>mook kim</lastname>
	       <nickname>mkyong</nickname>
	       <salary>100000</salary>
	   </staff>
	   <staff id="2001">
	       <firstname>low</firstname>
	       <lastname>yin fong</lastname>
	       <nickname>fong fong</nickname>
	       <salary>200000</salary>
	   </staff>
	   </company>
	   */

       try {
        File fXmlFile = new File("C:\\Java Workspace\\TempAbc\\xml.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile); 
        //optional, but recommended
        //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize(); 
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("staff");
        System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) 
            {
            	Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                	Element eElement = (Element) nNode; 
                	System.out.println("Staff id : " + eElement.getAttribute("id"));
                	System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                	System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                	System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                	System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());	
                }
            }
       } catch (Exception e) {
        e.printStackTrace();
       }
    }

}