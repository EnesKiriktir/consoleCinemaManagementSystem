
public class updateSaloon {
	////////////////////////////updating saloon 
	private String saloon;
	private Movie movie;
	
	
	public updateSaloon(String saloon, Movie movie) {
		this.saloon = saloon;
		this.movie = movie;
	}
	
	public String getSaloon() {
		return saloon;
	}

	public void setSaloon(String saloon) {
		this.saloon = saloon;
	}

	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public void disPlay()
	{
		System.out.println(saloon+": "+movie.getTitle());
	}
	
	
}
