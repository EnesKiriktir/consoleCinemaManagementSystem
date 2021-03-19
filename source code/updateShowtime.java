
public class updateShowtime {
	////////////////////////////////updating show time
	private String name;
	public char[][] saloon;
	private String time;
	private double price;
	private double[] watced=new double[9];
	
	public updateShowtime(String name, String time, double price) {
		saloon=new char[5][5];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				saloon[i][j]='O';
			}
		}
		this.name=name;
		this.time = time;
		this.price = price;
	}
	
	
	public double getWatch(int i) {/////Getting movies total prices
		return watced[i];
	}
	public void setWatch(int i,double money) {/////Setting movies total prices for sell ticket
		watced[i] +=money;
	}
	public void cancelWatch(int i,double money) {/////Setting movies total prices for cancel ticket
		watced[i] -=money;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public char getSalon(int i,int j) {/////Getting suits in saloons
		return saloon[i][j];
	}
	public void setXSalon(int i,int j) {/////Setting suits are full for sell ticket
		saloon[i][j]='X';
	}
	
	public void setOSalon(int i,int j)/////Setting suits are empty for cancel ticket
	{
		saloon[i][j]='O';
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void disPlay() {
		System.out.print(name+"-"+time);
	}
	
}
