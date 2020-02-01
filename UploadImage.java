package photos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/photos/UploadImage")
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlbumClass getEntry(int id) {
		ArrayList<AlbumClass> album
     	= (ArrayList<AlbumClass>) getServletContext().getAttribute("album");
		for(int i = 0;i<album.size();i++) {
			AlbumClass albums = album.get(i);
			if(albums.getAlbumID() == id)
				return albums;
		}
		return null;
	}
 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 int id = Integer.parseInt(request.getParameter("albumId"));
		 
	  AlbumClass albums = getEntry(id);	
	  DiskFileItemFactory factory= new DiskFileItemFactory();
	  ServletContext servletContext = this.getServletConfig()
	            .getServletContext();
	  File repository = (File) servletContext
	            .getAttribute( "javax.servlet.context.tempdir" );
	  factory.setRepository( repository );
	  ServletFileUpload upload = new ServletFileUpload( factory );
	  String fileDir = getServletContext().getRealPath( "/WEB-INF/uploads" );
	  
	  
	  
	  try
      {
          List<FileItem> items = upload.parseRequest( request );
          
          for (int i = 0; i < items.size(); i++) {
			FileItem item = items.get(i);
		
			
			
              if( !item.isFormField() )
              {
            	 String type = 	item.getContentType();
            	
                  String fileName = (new File( item.getName() )).getName();
                  
                
                
                albums.addPhoto(new PhotoClass(fileName,fileDir,type));
                
                 
                  File file = new File( fileDir, fileName );
                  item.write( file );
                  
              }
              
		}

      }catch( Exception e )
      {
          throw new IOException( e );
      }
	   
      
	  response.sendRedirect("PhotoAlbum?albumId=" + id);
      }
	}



