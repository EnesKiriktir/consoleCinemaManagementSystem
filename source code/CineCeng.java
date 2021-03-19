import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class CineCeng {
	CineCeng() throws IOException {
		////////////////////////////////////reading file for array indexes
		FileReader fileReader = new FileReader("input.txt");//open the file and read for array's index
		String line;		
		BufferedReader br = new BufferedReader(fileReader);
		int indexcounterStar=1,indexcounterMovie=1,indexcounterDirector=1;
		while ((line = br.readLine()) != null) {
			String[] arr1=line.split(";");
			//System.out.println(arr1[0]);
			if(arr1[0].equals("addStar")) {
				indexcounterStar++;
			}
			else if(arr1[0].equals("addDirector")) {
				indexcounterDirector++;
			}
			else if(arr1[0].equals("addMovie")) {
				indexcounterMovie++;
			}
		}
		br.close();	
		////////////////////////////////////creating necessary arrays and variables
		Star[] stars = new Star[indexcounterStar];
		Movie[] movies=new Movie[indexcounterDirector];
		Director[] directors = new Director[indexcounterMovie];	
		updateSaloon[] salonMovie=new updateSaloon[3];
		updateShowtime[] showTime=new updateShowtime[9];
		sellTicket[] st = new sellTicket[500]; 
		int counterStar=0, counterDirector=0,counterMovie=0,counterSaloons=0,counterSellTicket=0,counterupdate=0;
		Random rndm=new Random();
		
		
		
		////////////////////////////////////reading file for split
		FileReader fileReader1 = new FileReader("input.txt");
		String line1;
		BufferedReader br1 = new BufferedReader(fileReader1);
		while ((line1 = br1.readLine()) != null) {
			String[] arr=line1.split(";");
			if(arr[0].equals("addStar")){	////////////////////////////////////adding a star
				stars[counterStar]= new Star(counterStar+1,arr[1],arr[2],arr[3]);/////Star id,Star name,Star birthdate,Star birth place
				counterStar++;
			}
			else if(arr[0].equals("addDirector")){////////////////////////////////////adding a star
				directors[counterDirector]= new Director(counterDirector+1, arr[1],arr[2],arr[3]);/////Director id,Director name,Director birthdate,Director birth place
				counterDirector++;
			}
			else if(arr[0].equals("addMovie")) {////////////////////////////////////adding a movie
				Star[] tempid=new Star[arr.length]; /// temporary Star array for Movie stars
				int k=0;
				for(int i=5;i<arr.length;i++) {//////Found Star id's and keep in Movie
					tempid[k]=stars[(Integer.parseInt(arr[i])-1)];
					k++;
				}
				movies[counterMovie]= new Movie(counterMovie+1, arr[1],arr[2],arr[3],arr[4],tempid);/////Movie id,Movie title, Movie genre,Movie Duration ,Stars
				counterMovie++;				
			}
			else if(arr[0].equals("updateSaloon")){////////////////////////////////////updating a saloon
					salonMovie[counterupdate]= new updateSaloon(arr[1], movies[Integer.parseInt(arr[2])-1]);//saloon name,movie
					counterupdate++;
				}
			
			else if(arr[0].equals("updateShowtime")) {////////////////////////////////////updating a show time
				double a=Double.parseDouble(arr[3]);///movie's price
					showTime[counterSaloons]= new updateShowtime(arr[1],arr[2],a);//saloon name, movie time, movie price
					counterSaloons++;
			}
			else if(arr[0].equals("sellTicket")){////////////////////////////////////selling a ticket 
				String a=arr[3];///////for suit substring 
				int i=((Integer.parseInt(a.substring(1,2)))-1);////for suit column
				if(a.substring(0, 1).equals("A")) {/////if first row
					for(int j=0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName()))/////find show time
						{
							st[counterSellTicket]=new sellTicket(showTime[j],0,i,arr[4]);//Movie show time,suit row,suit column,ticket type
							if(st[counterSellTicket].isEmpty()) //if suit is empty
							{
								st[counterSellTicket].setMoney(j);//getting money
								counterSellTicket++;
							}
							else {//if suit is not empty
								do{///randomly generated suit 
									int row = rndm.nextInt(5);
									int column = rndm.nextInt(5);
									st[counterSellTicket]=new sellTicket(showTime[j],row,column,arr[4]);//Movie show time,suit row,suit column,ticket type
								}while(!st[counterSellTicket].isEmpty());///while finding a empty suit
								st[counterSellTicket].setMoney(j);//getting money
								counterSellTicket++;
								
							}
						}
					}
				}
				else if(a.substring(0, 1).equals("B")) {/////if second row
					for(int j=0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName())){
							st[counterSellTicket]=new sellTicket(showTime[j],1,i,arr[4]);
							if(st[counterSellTicket].isEmpty()) {
								st[counterSellTicket].setMoney(j);
								counterSellTicket++;
							}
							else {
								do{
									int row = rndm.nextInt(5);
									int column = rndm.nextInt(5);
									st[counterSellTicket]=new sellTicket(showTime[j],row,column,arr[4]);
								}while(!st[counterSellTicket].isEmpty());
								st[counterSellTicket].setMoney(j);
								counterSellTicket++;
								
							}
						}
					}
				}
				else if(a.substring(0, 1).equals("C")) {/////if third row
					for(int j=0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName())){
							st[counterSellTicket]=new sellTicket(showTime[j],2,i,arr[4]);
							if(st[counterSellTicket].isEmpty()) {
								st[counterSellTicket].setMoney(j);
								counterSellTicket++;
							}
							else {
								do{
									int row = rndm.nextInt(5);
									int column = rndm.nextInt(5);
									st[counterSellTicket]=new sellTicket(showTime[j],row,column,arr[4]);
								}while(!st[counterSellTicket].isEmpty());
								st[counterSellTicket].setMoney(j);
								counterSellTicket++;
								
							}
						}
					}
				}
				else if(a.substring(0, 1).equals("D")) {///if fourth row
					for(int j=0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName())){
							st[counterSellTicket]=new sellTicket(showTime[j],3,i,arr[4]);
							if(st[counterSellTicket].isEmpty()) {
								st[counterSellTicket].setMoney(j);
								counterSellTicket++;
							}
							else {
								do{
									int row = rndm.nextInt(5);
									int column = rndm.nextInt(5);
									st[counterSellTicket]=new sellTicket(showTime[j],row,column,arr[4]);
								}while(!st[counterSellTicket].isEmpty());
								st[counterSellTicket].setMoney(j);
								counterSellTicket++;
								
							}
						}
					}
				}
				else if(a.substring(0, 1).equals("E")) {//if fifth row
					for(int j=0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName())){
							st[counterSellTicket]=new sellTicket(showTime[j],4,i,arr[4]);
							if(st[counterSellTicket].isEmpty()) {
								st[counterSellTicket].setMoney(j);
								counterSellTicket++;
							}
							else {
								do{
									int row = rndm.nextInt(5);
									int column = rndm.nextInt(5);
									st[counterSellTicket]=new sellTicket(showTime[j],row,column,arr[4]);
								}while(!st[counterSellTicket].isEmpty());
								st[counterSellTicket].setMoney(j);
								counterSellTicket++;
							}
						}
					}
				}
			}	
			else if (arr[0].equals("cancelTicket")){////////////////////////////////////Canceling a ticket 
				String a=arr[3];///////for suit substring 
				int i=((Integer.parseInt(a.substring(1,2)))-1);////for suit column
				if(a.substring(0, 1).equals("A")) {//if first row
					for(int j = 0;j<showTime.length;j++) 
					{
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName())) {/////find show time
							for(int k = 0;k<counterSellTicket;k++) {
								if(st[k].getRow()==0 &&st[k].getSeat() == i && showTime[j].getSalon(0, i)=='X') { //checking row,suit and not empty
									st[k].cancelMoney(j);///Setting money
									showTime[j].setOSalon(0,i);/////setting suit 'O'
								}
							}							
						}
					}
				}
				else if(a.substring(0, 1).equals("B")) {//if second row
					for(int j = 0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName() )) {
							for(int k = 0;k<counterSellTicket;k++) {
								if(st[k].getRow()==1 && st[k].getSeat() == i && showTime[j].getSalon(1, i)=='X') { 
									st[k].cancelMoney(j);
									showTime[j].setOSalon(1,i);
								}
							}							
						}
					}
				}
				else if(a.substring(0, 1).equals("C")) {//if third row
					for(int j = 0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName())) {
							for(int k = 0;k<counterSellTicket;k++) {
								if(st[k].getRow()==2 && st[k].getSeat() == i && showTime[j].getSalon(2, i)=='X') { 
									st[k].cancelMoney(j);
									showTime[j].setOSalon(2,i);
								}
							}							
						}
					}
				}
				else if(a.substring(0, 1).equals("D")) {//if fourth row
					for(int j = 0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName())) {
							for(int k = 0;k<counterSellTicket;k++) {
								if(st[k].getRow()==3  && st[k].getSeat() == i && showTime[j].getSalon(3, i)=='X') { 
									st[k].cancelMoney(j);
									showTime[j].setOSalon(3,i);
								}
							}							
						}
					}
				}
				else if(a.substring(0, 1).equals("E")) {//if fifth row
					for(int j = 0;j<showTime.length;j++) {
						if(arr[2].equals(showTime[j].getTime()) && arr[1].equals(showTime[j].getName())) {
							for(int k = 0;k<counterSellTicket;k++) {
								if(st[k].getRow()==4  && st[k].getSeat() == i && showTime[j].getSalon(4, i)=='X') {
									showTime[j].setOSalon(4, i);
									st[k].cancelMoney(j);
								}
							}							
						}
					}
				}
			}
		}
	br1.close();	
	
	///////////////////finish the reading 
	///////////////////getting input
	int input;
	input inp=new input();
	do {
		input=inp.getInput(showTime,salonMovie);//for classes get show time and update saloon
	}while(input!=0);
	//////////////////End the day
	Screen sc=new Screen(showTime,salonMovie,sellTicket.getMoney());
	sc.show();
	}
}
