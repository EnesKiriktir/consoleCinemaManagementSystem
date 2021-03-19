
public class Movie {
	////////////////////adding a movie
	int id;
	private String title;
	private String genre;
	private String duration;
	private String directorId;///////parsing in get method
	private Star[] stars;
	
	Movie(int getid, String getTitle, String getGenre, String getDuration, String getDirector, Star s[] ) {
		id=getid;
		title=getTitle;
		genre=getGenre;
		duration=getDuration;
		directorId=getDirector;
		stars=s;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}


	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	int getDuration() {return Integer.parseInt(duration);}
	int getDirectorId() {return Integer.parseInt(directorId);}
	void getStars() {
		for(int i=0;i<=4;i++) {
			System.out.println(stars[i]);	
		}
	}
	
	public void displayMovies() {
		System.out.println(title+" is a "+genre+" film "+duration+" dk. ");
		
	}
}
