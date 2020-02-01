package photos;

public class PhotoClass {

	 int photoID;
	 static int count = 0;
	String path;
	String fileName;
	String contentType;
	
	public PhotoClass(String fileName,String path, String contentType) {
		super();
		this.photoID=count++;
		this.fileName = fileName;
		this.path = path;	
		this.contentType = contentType;
	}
	public int getPhotoID() {
		return photoID;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	
}
