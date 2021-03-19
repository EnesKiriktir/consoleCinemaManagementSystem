
import enigma.core.Enigma;

public class Screen {
	////////////////////////////////////////end the day
	updateShowtime[] shows;
	updateSaloon[] saloon;
	double money;
	Screen(updateShowtime[] show,updateSaloon[] saloon,double money){
		this.shows=show;
		this.saloon=saloon;
		this.money=money;
	}
	
	//////////////////////////////////////how much suit is full
	public Movie getMostWatched() {
		int counter1=0,counter2=0,counter3=0;
		Movie mv = null;
		char[][] arr= new char[5][5];
		for(int i=0;i<3;i++) {///for saloon 1's show times
			arr=shows[i].saloon;
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<arr[0].length;k++){////counting full suit
					if(arr[j][k]=='X') counter1++;
				}
			}	
		}
		for(int i=3;i<6;i++) {////for saloon 2's show time
			arr=shows[i].saloon;
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<arr[0].length;k++){
					if(arr[j][k]=='X') counter2++;
				}
			}	
		}
		for(int i=6;i<9;i++) {////for saloon 3's show time
			arr=shows[i].saloon;
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<arr[0].length;k++){
					if(arr[j][k]=='X') counter3++;
				}
			}	
		}
		/////////return which biggest
		if (counter1>counter2 && counter1>counter3) {
			mv=saloon[0].getMovie();
		}
		if (counter2>counter1 && counter2>counter3) {
			mv=saloon[3].getMovie();
		}
		if (counter3>counter2 && counter3>counter1) {
			mv=saloon[6].getMovie();
		}

		return mv;
	}
	///////////////////////////////////////most-filled
	public updateShowtime getmostFilled() {
		double enbuyuk=0,counter=0;
		char[][] arr=new char[5][5];
		updateShowtime us=null;
		for(int i=0;i<shows.length;i++) {
			arr=shows[i].saloon;
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<arr[0].length;k++){//counting every show time for find count sell ticket
					if(arr[j][k]=='X') counter++;
				}
			}
			if(enbuyuk<counter) {//return biggest
				enbuyuk=counter;
				us=shows[i];
			}
			counter=0;
		}
		return us;
	}
	////////////////////////////////high-income
	public void highMovie() {
		Movie m=null;
		double counter1=0,counter2=0,counter3=0;
		for(int i=0;i<3;i++) {
			counter1+=shows[i].getWatch(i);///getting total movie price
		}
		for(int i=3;i<6;i++) {
			counter2+=shows[i].getWatch(i);
		}
		for(int i=6;i<9;i++) {
			counter3+=shows[i].getWatch(i);
		}
		if (counter1>counter2 && counter1>counter3) {//return biggest
			System.out.println("The highest-income movie:  "+saloon[0].getMovie().getTitle()+" - "+counter1);
		}
		if (counter2>counter1 && counter2>counter3) {
			System.out.println("The highest-income movie:  "+saloon[1].getMovie().getTitle()+" - "+counter2);
		}
		if (counter3>counter2 && counter3>counter1) {
			System.out.println("The highest-income movie:  "+saloon[2].getMovie().getTitle()+" - "+counter3);
		}
		
	}
	public void show() {
		enigma.console.Console cn = Enigma.getConsole("Theatre");
		for(int i=0;i<80;i++) System.out.println();
		cn.getTextWindow().setCursorPosition(0, 0);
		Enigma.getConsole("Theatre",80,30,12,0);
		Movie mv;
		String input=null;
		////////////////////////////////////////////////////////writting screen
		mv=getMostWatched();
		System.out.println("The most-watched movie: "+mv.getTitle());
		System.out.println("Total revenue of CineCeng: "+money);
		System.out.println("The most-filled showtime: "+getmostFilled().getName()+"-"+getmostFilled().getTime()); 
		highMovie();
		
		///////////////////////////////////////////////saloons
		cn.getTextWindow().setCursorPosition(12, 4); System.out.print("s1");
		cn.getTextWindow().setCursorPosition(18, 4); System.out.print("s2");
		cn.getTextWindow().setCursorPosition(24, 4); System.out.print("s3");
					
		cn.getTextWindow().setCursorPosition(0, 7); System.out.print("Morning");
		cn.getTextWindow().setCursorPosition(0, 13); System.out.print("Noon");
		cn.getTextWindow().setCursorPosition(0, 19); System.out.print("Evening");
					
		int y=5,x=10;
		for(int i=0;i<9;i+=3) {	
			for(int j=0;j<5;j++)
			{
				cn.getTextWindow().setCursorPosition(x, y++);
				for(int k=0;k<5;k++)
				{
					System.out.print(shows[i].getSalon(j, k));
				}	
			}
			x+=6;
			y=5;
		}
		x=10;
		y=11;
		for(int i=1;i<9;i+=3) 
		{		
			for(int j=0;j<5;j++)
			{
				cn.getTextWindow().setCursorPosition(x, y++);
				for(int k=0;k<5;k++)
				{
					System.out.print(shows[i].getSalon(j, k));
					}	
				}
			x+=6;
			y=11;
			}
		x=10;
		y=17;
		for(int i=2;i<9;i+=3) 
		{
			for(int j=0;j<5;j++)
			{
				cn.getTextWindow().setCursorPosition(x, y++);
				for(int k=0;k<5;k++)
				{
					System.out.print(shows[i].getSalon(j, k));
				}	
			}
		x+=6;
		y=17;
		}		
	}
}
