package photos;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/photos/DeleteAlbum")
public class DeleteAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("albumId"));
		ArrayList<AlbumClass> album = (ArrayList<AlbumClass>) getServletContext().getAttribute("album");
		//ArrayList<PhotoClass> photo = (ArrayList<PhotoClass>) getServletContext().getAttribute("photo");
		for(int i = 0; i<album.size();i++) {
			if(id==album.get(i).getAlbumID())
				album.remove(i);
			     
		}
		response.sendRedirect("albums");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
