package main;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import org.w3c.dom.*;
import helper.ReadFileXml;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	LinkedList<String> name = new LinkedList<String>();
    	LinkedList<String> url = new LinkedList<String>();
    	Document document = ReadFileXml.readFileXml("D:\\data.xml");
    	NodeList nodeListPlace = document.getElementsByTagName("place");
    	int length = nodeListPlace.getLength();
        for(int i = 0; i < length; i++) {
         	Node node = nodeListPlace.item(i);
         	if (node.getNodeType() == Node.ELEMENT_NODE) {
                 Element element = (Element) node;
                 name.add(element.getElementsByTagName("name")
                         .item(0).getTextContent());
                 url.add(element.getElementsByTagName("url")
                         .item(0).getTextContent());
             }
         }
        request.setAttribute("name", name);
        request.setAttribute("length", length);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
 
    public void destroy() {}
}
