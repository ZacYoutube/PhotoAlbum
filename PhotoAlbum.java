package photos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/photos/PhotoAlbum")
public class PhotoAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
private AlbumClass getEntry(int id) {
		
		// Get a reference to the guest book
		ArrayList<AlbumClass> album = (ArrayList<AlbumClass>) getServletContext().getAttribute("album");
		
		// Find the entry that matches the specified ID
		for(AlbumClass entry : album) {
			if (entry.getAlbumID() == id)
				return entry;
		}
		
		return null;
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("albumId"));
        AlbumClass entry = getEntry(id);     
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        
        out.println("<head>");
        out.println("    <meta charset=\"UTF-8\">");
        out.println("    <title>View Album</title>");
        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
        out.println("<style>");
        out.println("header > h1 { display: inline-block; }");
        out.println("header span { margin-left: 5px; }"); 
        out.println("body{");
        out.println("background-image: url(https://img.clipartxtras.com/2e4282d50f907ed194435f1135158167_gif-mine-face-draws-ily-get-this-to-1k-get-this-famous-ensomnic-transparent-drawing-gif_500-226.gif);background-repeat:no-repeat;background-size:200px 50px;background-position:350px 60px");
        out.println("}");
        
        out.println("</style>");
        
        out.println("</head>");
        out.println("<body>");
        out.println("<div>");
       
        out.println("<header>");
        out.println("<h1> Photo Albums</h1>");
        out.println("<span> <a href=\"DeleteAlbum?albumId=" + entry.getAlbumID() + "\"><font size=\"2.5\" face=\"Times New Roman\" color=\"Blue\">Delete Album</font></a></span>");
        out.println("</header>");
        out.println(entry.getAlbumName() + " - " + entry.getAlbumDescrption());
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");

       
        out.println("<div class=\"container\">\n" + 
        		"");
        for(int i = 0;i<entry.getPhoto().size();i++) {
          
        	out.println("<img src=\"viewImage?name="+entry.getPhoto().get(i).getFileName() +"\"height = \"230\" width = \"300\">");
        	out.println("<p><a  href=\"DeletePhoto?albumId=" + entry.getAlbumID() +"&name="+entry.getPhoto().get(i).getFileName()+"\">delete photo</a></p>");
        	out.println("<p><a  href=\"View?albumId="+entry.getAlbumID()+"&value=" + entry.getPhoto().get(i).getFileName()+"\" >View photo</a></p>");
        	out.println("<p><a href=\"viewImage?name=" + entry.getPhoto().get(i).getFileName() +"&download=\"true\">Download</a></p>");
        	out.println("<br>");
        	}
        
        
        out.println("</div>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("<h4>Add An Image</h4>");
        out.println("<form action = \"UploadImage?albumId=" + id +"\" method = \"post\" enctype = \"multipart/form-data\">");
        out.println("<input type = \"file\" name = \"file\" accept=\"image/gif, image/jpeg, image/png\"size = \"50\" />");
        out.println("<br>");
        out.println("<input type = \"submit\" value = \"Upload File\" />");
        out.println("</form>");
        out.println("<a href=\"albums\">Back to the albums</a>");
        
     
        out.println("</body>");        
        out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
