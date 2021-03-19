
public class Star {
	//////////////////////////////////Keep stars
	int id;
	private String name;
	private String bDate;
	private String bPlace;
	
	Star(int getid, String getName, String getBDate, String getBPlace) {
		id=getid;
		name = getName;
		bDate = getBDate;
		bPlace = getBPlace;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getbDate() {
		return bDate;
	}


	public void setbDate(String bDate) {
		this.bDate = bDate;
	}


	public String getbPlace() {
		return bPlace;
	}


	public void setbPlace(String bPlace) {
		this.bPlace = bPlace;
	}


	public void displayActors() {
		System.out.println(name+"'s birth date is "+bDate+" and birth place is "+bPlace);
	}
}
