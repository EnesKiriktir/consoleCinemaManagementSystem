
public class sellTicket {
	//////////////////////selling a ticket
	static int counter=0;
	private String name;
	private String time;
	private int row;
	private int column;
	private String tipe;
	private static double money;
	private updateShowtime show;
	public sellTicket(updateShowtime show, int row, int column, String tipe) {
		this.show=show;
		this.row = row;
		this.column = column;
		this.tipe = tipe;
		counter++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	//////////////////////////Checking the suit
	boolean isEmpty() {
		if(show.getSalon(row,column)=='X') {///if suit 'X' is empty
			return false;
		}
		else {
			show.setXSalon(row,column);//if is not empty we are setting suit 'X' because will sell
			return true;
		}
	}
	
	public int counterTicker() {
		return counter;
	}
	
	//////////////////////Keeping total money
	public void setMoney(int i) {
		if(tipe.equalsIgnoreCase("student")) {///if the customer is student, we get half price
			money+=show.getPrice()/2;
			show.setWatch(i,show.getPrice()/2);//////Setting movies money
		}
		else if(tipe.equalsIgnoreCase("regular")) {
			money+=show.getPrice();
			show.setWatch(i,show.getPrice());
		}
	}
	public void cancelMoney(int i) {
		if(tipe.equalsIgnoreCase("student")) {
			money-= show.getPrice()/2;
			show.cancelWatch(i, show.getPrice()/2);
		}
		else if(tipe.equalsIgnoreCase("regular")) {
			money-= show.getPrice();
			show.cancelWatch(i, show.getPrice());
		}
	}
	public  int getRow() { // cancel yaparken koltuk sütunun eþitliðini kontrol etmek için kullanýlýr
		return row;
	}
	public  int getSeat() { // cancel yaparken koltuk sütunun eþitliðini kontrol etmek için kullanýlýr
		return column;
	}
	public static  double getMoney() {
		return money;
	}
	public void disPlay() {
		System.out.println(money);
	}
}
