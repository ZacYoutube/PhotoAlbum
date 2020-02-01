package photos;

import java.util.ArrayList;
public class AlbumClass {

	static int count = 0;
	int albumID;
	String albumName, albumDescrption;
	ArrayList<PhotoClass> photo = new ArrayList<>();

	
	public AlbumClass(String albumName, String albumDescrption) {
		super();
		this.albumID=count++;
		this.albumName = albumName;
		this.albumDescrption = albumDescrption;
	}
	
	public int getAlbumID() {
		return albumID;
	}
	public void addPhoto(PhotoClass photos) {
		this.photo.add(photos);
	}
	public ArrayList<PhotoClass> getPhoto(){
		return photo;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getAlbumDescrption() {
		return albumDescrption;
	}
	public void setAlbumDescrption(String albumDescrption) {
		this.albumDescrption = albumDescrption;
	}
	
	
	
	
	
	
}
