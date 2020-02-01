package photos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/photos/albums")
public class albums extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		// Create a local array list of album entries
		ArrayList<AlbumClass> album = new ArrayList<>();
		

		// Store the album in the Application Scope (ServletContext)
		
		
	
		getServletContext().setAttribute("album", album);
		
	}
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");	        
	        PrintWriter out = response.getWriter();
	        out.println("<!DOCTYPE html>");
	        out.println("<html lang=\"en\">");       
	        out.println("<head>");
	        out.println("    <meta charset=\"UTF-8\">");
	        out.println("    <title>Albums</title>");
	        out.println("     <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
	        out.println("<style>");
	        out.println(".inline-block {");
	        out.println("display: inline-block;");
	        out.println("}"); 
	        out.println("body{");
	        out.println("background-image: url(https://media.giphy.com/media/pmeCqErh8uwKI/giphy.gif);background-repeat:no-repeat;background-size:950px,300px");
	        out.println("}");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class=\"container\">");
	        out.println("<h1>Photo Albums</h1>"); 
	        
	        ArrayList<AlbumClass> album 
        	= (ArrayList<AlbumClass>) getServletContext().getAttribute("album");
	        out.println("You have " + album.size() + " albums available.<br><br>");
	        if(album.size()==0) {
	        	 out.println("<p><img src= https://www.gumtree.com/static/1/resources/assets/rwd/images/orphans/a37b37d99e7cef805f354d47.noimage_thumbnail.png height=\"80\" width=\"80\"></p>");
	        }
//	        ArrayList<PhotoClass> photo
//        	= (ArrayList<PhotoClass>) getServletContext().getAttribute("photo");
	    	
	        
	        for(int i = 0;i<album.size();i++) {
	        	AlbumClass albums = album.get(i);
	        	out.println("<div class=\"inline-block\">");
        		if(albums.getPhoto().size()==0) {   
        		out.println("<img src=https://www.gumtree.com/static/1/resources/assets/rwd/images/orphans/a37b37d99e7cef805f354d47.noimage_thumbnail.png height = \"100\" width = \"100\">");
        		}else {
        			
        	    out.println("<img src=\"viewImage?name=" +albums.getPhoto().get(0).getFileName() +"\"height = \"100\" width = \"100\">");
        		
        		}
      	
	        	out.println("<p><font size=\"2.2\">Name:</font><b>"+albums.getAlbumName()+ "</b> (<font size=\"2\"><b>" + albums.getPhoto().size()+ " photo(s))</b></font></p>" + "<p style=\"width:220px;\"><font size=\"2.2\">Description:</font><font size=\"1\" face=\"Comic Sans MS\" color=\"black\"><b>"+albums.getAlbumDescrption()+"</b></font></p>");
	        	out.println(" <a href=\"DeleteAlbum?albumId=" + albums.getAlbumID() + "\"><font size=\"2.5\" face=\"Times New Roman\"><button>Delete Album</button></font></a>");
	        	out.println(" <a href=\"PhotoAlbum?albumId=" + albums.getAlbumID() +"\"><font size=\"2.5\" face=\"Times New Roman\"><button>View</button></font></a> ");
	        	out.println("</div>");
	        }
	       
	        out.println("<a class=\"btn btn-info\" href=\"AddAlbum\">Add Album</a>");
	        out.println("</div>");
	        out.println("</body>");        
	        out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
