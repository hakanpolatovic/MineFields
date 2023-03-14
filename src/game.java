import java.util.Scanner;
import java.util.Random;
public class game {
	public static void endgame() {
		System.out.println("KABOOM! You are fucking dead");
		System.out.println("type '1' if you want to try again");
		Scanner scan = new Scanner (System.in);
		int answer = scan.nextInt();
		if(answer==1) {
			
			generation();
		}
		else{
			
			endgame();
		}	
	}
	public static void gamewon() {
		System.out.println("Congratz You Have Won!");
		System.out.println("Please type 1 if you want to play again");
		Scanner scan = new Scanner (System.in);
		int answer3 = scan.nextInt();
		if(answer3==1) {
			
			generation();
		}
		else{
			
			endgame();
		}	
	}
	
	
	public static void generation() {
		Scanner scan = new Scanner (System.in);
		int bombnumber = 1;
		System.out.println("Please select number of rows!");
		int rows = scan.nextInt();
		if(rows<=1) {
			System.out.println("The number must be higher than 1");
			generation();
		}
		System.out.println("Please select number of columns!");
		int columns = scan.nextInt();
		if(columns<=1) {
			System.out.println("The number must be higher than 1");
			generation();
		}
		System.out.println("Please select difficulty! 1-Easy 2-Normal 3-Hard");
		int difficulty = scan.nextInt();
		if(difficulty != 1 & difficulty != 2 & difficulty != 3) {
			System.out.println("The number must between 1 and 3");
			generation();
		}
		if(difficulty ==1) {
			
			bombnumber = rows*columns/3;
			
			
		}
		if(difficulty ==2) {
			
			bombnumber = rows*columns/2;
			
			
		}
		if(difficulty ==3) {
	
			bombnumber = (rows*columns)-(rows*columns/4);
	
	
		}
		int [][] field= new int [rows] [columns];
		int [][] checker= new int [rows] [columns];
		System.out.println("The Field Has Created!");
		System.out.println("Now There are " +rows*columns+ " Fields!");
		System.out.println("And There is " +bombnumber+ " Bombs!");
		int fieldsize = rows*columns;
		float bombx = bombnumber;
		float sizex = fieldsize;
		float possiblebomb= bombx/sizex;
		System.out.println("The Possibility to hit a bomb is:");
		System.out.printf("%,.2f", possiblebomb);
		System.out.println();
			
		for(int z=bombnumber; z>=1;) {
			long x = Math.round( Math.random() );
			int min = 0; // Minimum value of range
			int max = rows-1; // Maximum value of range
			int random_row = (int)Math.floor(Math.random() * (max - min + 1) + min);
			int mini = 0; // Minimum value of range
			int maxi = columns-1; // Maximum value of range
			int random_column = (int)Math.floor(Math.random() * (maxi - mini + 1) + min);
			if(checker[random_row][random_column] !=1) {
			checker[random_row][random_column] = 1;
			z--;
			}
	
	}
		boolean onbomb=false;
		int quesscounter =0;
		while(onbomb==false) {
			if(quesscounter==fieldsize-bombnumber) {
				gamewon();
				break;
			}
			System.out.println("Select a row to look at");
			int selectedrow=scan.nextInt();
			System.out.println("Select a column to look at");
			int selectedcolumn=scan.nextInt();
			if(checker[selectedrow][selectedcolumn]==2)
			{
				System.out.println("You have already checked here! Its Empty");
			}
			if(checker[selectedrow][selectedcolumn]==1) {
				onbomb=true;
				endgame();
			}
			if(checker[selectedrow][selectedcolumn]==0){
				System.out.println("Cool!This is Empty");
				checker[selectedrow][selectedcolumn] = 2;
				quesscounter++;
			}
			
		}
		
		
		
			
	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		generation();
		
	}

}
