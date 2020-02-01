package photos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/photos/DeletePhoto")
public class DeletePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AlbumClass getEntry(int id) {
    	ArrayList<AlbumClass> album
     	= (ArrayList<AlbumClass>) getServletContext().getAttribute("album");
    	for(int i = 0;i<album.size();i++) {
    		AlbumClass albums = album.get(i);
    		if(albums.getAlbumID()==id)
    			return albums;
    	}
    	return null;
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("albumId"));
		AlbumClass albums = getEntry(id);
		String fileDir = getServletContext().getRealPath( "/WEB-INF/uploads" );
		for(int i = 0;i<albums.getPhoto().size();i++) {
			if(albums.getPhoto().get(i).getFileName().equals(name)) {
				
				File f=new File(fileDir+"/"+albums.getPhoto().get(i).getFileName());
				if(f.exists())
				f.delete();
				albums.getPhoto().remove(i);
				
			}
		}
		
		
		response.sendRedirect("PhotoAlbum?albumId=" + id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
