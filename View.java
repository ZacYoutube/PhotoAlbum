package photos;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/photos/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("albumId"));
		String name = request.getParameter("value");
		
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
        print.println("<img src=\"viewImage?name=" + name + "\" height = \"700\" width = \"1000\">");
        print.println("<p><a href=\"albums\"><font size=\"2.5\" face=\"Times New Roman\" color=\"Blue\">Back to the albums</font></a></p>");
	    print.println("<p><a href=\"DeletePhoto?albumId="+id+"&name=" + name +"\"><font size=\"2.5\" face=\"Times New Roman\" color=\"Blue\">Delete Photo</font></a></p>"); 
	    print.println("<p><a href=\"viewImage?name=" + name +"&download=\"true\"><font size=\"2.5\" face=\"Times New Roman\" color=\"Blue\">Download</font></a></p>");
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
