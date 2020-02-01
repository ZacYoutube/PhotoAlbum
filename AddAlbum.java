package photos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.GuestBookEntry;

@WebServlet("/photos/AddAlbum")
public class AddAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>Add Album</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("<style>");
        out.println("body{");
        out.println("background-image: url(https://img1.picmix.com/output/stamp/normal/1/3/0/4/644031_3a2e9.gif),url(http://www.alldogssite.com/animpandawave.gif);background-repeat:no-repeat,no-repeat;background-position:left top, 300px");
      
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");
        String albumName = request.getParameter("albumName");
        String albumDescription = request.getParameter("albumDescription");
        ArrayList<AlbumClass> album = (ArrayList<AlbumClass>) getServletContext().getAttribute("album");
       
        if (albumName == null)
        	albumName = "";
        
        if (albumDescription == null)
        	albumDescription = "";
        
        out.println("<h1>Add Album</h1>");
        out.println("<form action=\"AddAlbum\" method=\"post\">");
        out.println("Album Name: <input type=\"text\" name=\"albumName\" value=\"" + albumName + "\"> <br>");
        
        if (request.getAttribute("albumNameError") != null)
        	out.println("   <p class=\"text-danger\">Please enter album name</p>");
        
        out.println(" 	Album Description: <br>");
        out.println(" 	<textarea name=\"albumDescription\">" + albumDescription + "</textarea><br>");
        
        if (request.getAttribute("albumDescriptionError") != null)
        	out.println("   <p class=\"text-danger\">Please enter album description</p>");
        
        out.println(" 	<input class=\"btn btn-info\" type=\"submit\" name=\"submitBtn\" value=\"Add Album\">");
        out.println("</form>");
       
        out.println("</div>");
        out.println("</body>");        
        out.println("</html>");
        
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String albumName = request.getParameter("albumName");
		String albumDescription = request.getParameter("albumDescription");
		
		boolean isValidName = albumName != null && albumName.trim().length() > 0;
		boolean isValidDescription = albumDescription != null && albumDescription.trim().length() > 0;
		
		if (isValidName && isValidDescription) {
			// Get a reference to the guest book
			ArrayList<AlbumClass> album = (ArrayList<AlbumClass>) getServletContext().getAttribute("album");
			
			
			// Add a new entry
			album.add(new AlbumClass(albumName, albumDescription));
			
			// Redirect the User back to the main page
			//response.sendRedirect("../photos/albums");
			
			
			response.sendRedirect("albums");
		}
		else {
			
			if (!isValidName)
				request.setAttribute("albumNameError", true);
			
			if (!isValidDescription)
				request.setAttribute("albumDescriptionError", true);
			
			
			doGet(request, response);
			
			
		}
		
		
	}
	}


