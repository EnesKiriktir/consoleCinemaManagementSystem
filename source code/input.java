import java.util.Scanner;
import enigma.core.Enigma;

public class input {
	//////////////////////////////getting input
	int option;
	String input=null;
	int row,column;
	String saloon,time,type;
	updateShowtime[] show;
	sellTicket st;
	Screen sc;
	updateSaloon[] saloons;
	public int getInput(updateShowtime[] show,updateSaloon[] saloons)
	{
		this.show=show;
		this.saloons=saloons;
		enigma.console.Console cn = Enigma.getConsole("Theatre");
		Scanner sc= new Scanner(System.in);
		/////////////////////////////////////////////OPTIONS
		cn.getTextWindow().setCursorPosition(30, 0);
		System.out.println("////OPTIONS\\\\");
		cn.getTextWindow().setCursorPosition(20, 1);
		System.out.println("Press 1 for buy a ticket");
		cn.getTextWindow().setCursorPosition(20, 2);
		System.out.println("Press 2 for cancel a ticket");
		cn.getTextWindow().setCursorPosition(20, 3);
		System.out.println("Press 3 for end the day");
		cn.getTextWindow().setCursorPosition(0, 5);
		///////////////////////////////////////////MOVIES
		option=sc.nextInt();
		if(option==1)///sell a ticket
		{	////////////////////////////getting ticket information
			System.out.println("Enter a saloon(s1,s2,s3):  ");
			saloon=sc.next();
			System.out.println("Enter a time(morning,noon,evening):  ");
			time=sc.next();
			for(int i=0;i<show.length;i++)//print saloon
			{
				if(show[i].getName().equals(saloon) && show[i].getTime().equalsIgnoreCase(time))//find show time
				{
					for(int j=0;j<5;j++) {
						for(int k=0;k<5;k++)
						{
							System.out.print(show[i].getSalon(j, k));
						}
						System.out.println();
					}
				}
			}
			System.out.println();
			System.out.println("Enter a suits row number:  ");
			row = sc.nextInt();
			System.out.println("Enter a suits column number:  ");
			column = sc.nextInt();
			System.out.println("Enter a type(student,regular):   ");
			type = sc.next();
			
			for(int i=0;i<show.length;i++)
			{
				if(show[i].getName().equals(saloon) && show[i].getTime().equalsIgnoreCase(time))//find show time
				{
					if(show[i].getSalon(row-1, column-1)=='X') ///if it is not empty
						System.out.println("This suit is full");
					else
					{//if it is empty
						st=new sellTicket(show[i],row-1,column-1,type);//show time,suit row,suit column,costumer type
						st.setMoney(i);//setting money
						show[i].setXSalon(row-1,column-1);//setting suit
						System.out.println("Enjoy the movie ");
					}
				}
			}
		}
		else if(option==2)//cancel a ticket
		{	////////////////////////////getting ticket information
			System.out.println("Enter a saloon(s1,s2,s3):  ");
			saloon=sc.next();
			System.out.println("Enter a time(morning,noon,evening):  ");
			time=sc.next();
			for(int i=0;i<show.length;i++)
			{
				if(show[i].getName().equals(saloon) && show[i].getTime().equalsIgnoreCase(time))//find show time
				{
					for(int j=0;j<5;j++) {
						for(int k=0;k<5;k++)
						{
							System.out.print(show[i].getSalon(j, k));
						}
						System.out.println();
					}
				}
			}
			System.out.println("Enter a suits row number:  ");
			row = sc.nextInt();
			System.out.println("Enter a suits column number:  ");
			column = sc.nextInt();
			System.out.println("Enter a type(student,regular):   ");
			type = sc.next();
			for(int i=0;i<show.length;i++)
			{
				if(show[i].getName().equals(saloon) && show[i].getTime().equalsIgnoreCase(time))//find show time
				{
					if(show[i].getSalon(row-1, column-1)=='O') //if it is empty
						System.out.println("This suit is empty");
					else///if it is not empty
					{
						st=new sellTicket(show[i],row-1,column-1,type);//show time,suit row,suit column,costumer type
						st.cancelMoney(i);//setting money
						show[i].setOSalon(row-1,column-1);//setting suit
						System.out.println("Your transaction is complete.");
					}
				}
			}
			
		}
		else if(option==3)//end the day
		{
			return 0;
		}	
		return 1;
	}
}
