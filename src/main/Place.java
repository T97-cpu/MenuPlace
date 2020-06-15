package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import helper.ReadFileXml;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Place extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String parameter = request.getParameterValues("name")[0];
    	String url = "", name = "", description = "";
    	Document document = ReadFileXml.readFileXml("D:\\data.xml");
    	NodeList nodeListPlace = document.getElementsByTagName("place");
        for(int i = 0; i < nodeListPlace.getLength(); i++) {
         	Node node = nodeListPlace.item(i);
         	if (node.getNodeType() == Node.ELEMENT_NODE) {
                 Element element = (Element) node;
                 String nodeName = element.getElementsByTagName("name")
                         .item(0).getTextContent();
                 if(parameter.equals(String.join("-",nodeName.split(" ")))) {
                	 name = nodeName;
                	 url = element.getElementsByTagName("url")
                             .item(0).getTextContent();
                	 description = element.getElementsByTagName("description")
                             .item(0).getTextContent();
                 }
             }
         }
        request.setAttribute("name", name);
        request.setAttribute("url", url);
        request.setAttribute("description", description);

        RequestDispatcher dispatcher = request.getRequestDispatcher("place.jsp");
        dispatcher.forward(request, response);
    }
 
    public void destroy() {}
}
