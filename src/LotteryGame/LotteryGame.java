package NewLotoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LotteryGame {

	static Scanner s = new Scanner(System.in);

	public static List<Integer> LotoNumbers = new ArrayList<Integer>(); 
	public static List<Integer> UsersNumber = new ArrayList<Integer>();

	final static int lotoMin = 1;
	final static int lotoMax = 39;

	static int randomNum;
	static int enterNumbers;
	static int matched;


	public static int getRandomNum() {
		return randomNum;
	}
	public static void setRandomNum(int randomNum) {
		LotoGame2.randomNum = randomNum;
	}
	public static int getEnterNumbers() {
		return enterNumbers;
	}
	public static void setEnterNumbers(int enterNumbers) {
		LotoGame2.enterNumbers = enterNumbers;
	}
	public static int getMatched() {
		return matched;
	}
	public static void setMatched(int matched) {
		LotoGame2.matched = matched;
	}

	public static int numberGenerator(int min, int max){ 
		int number;
		number = min + (int)(Math.random() * ((max - min) + 1));
		return number;
	}

	public static void infoBox(String title, String infoMessage){     
		JOptionPane.showMessageDialog(null, infoMessage, title, JOptionPane.INFORMATION_MESSAGE); 
	}

	@SuppressWarnings("rawtypes")
	public static List drawingOfNumbers(){
		for(int i = 1; i <= 7;){
			int number = numberGenerator(lotoMin, lotoMax);
			LotoNumbers.add(number);
			Collections.sort(LotoNumbers);
			i++;
			}return LotoNumbers;	
		}	 
		
	

	@SuppressWarnings("rawtypes")
	public static List enterNum(){
		enterNumbers = 0;
		for(int i = 1; i <= 7; i++){
			System.out.println("Enter " + i + ". number!");	
			try{
				setEnterNumbers(s.nextInt());
			}
			catch(Exception e){
				infoBox("Error", "You can't enter a letters!"); 
				System.out.println("You must restart the game!");
				System.exit(0);
				UsersNumber.add(getEnterNumbers());
				matched++;
				Collections.sort(UsersNumber);
			}
		}
		return UsersNumber;
	} 

	public static void yesOrNo(String title, String poruka){  
		if (JOptionPane.showConfirmDialog(null, poruka, title,   
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
				== JOptionPane.YES_OPTION) 
		{ 
			
			drawingOfNumbers();
		}                 
		else  
		{
			
			System.exit(0);   
		}
	}
	public static void main(String[] args) {
		yesOrNo("Welcome!", "Do you want start the game?");
		infoBox("Hello!", "Welcome to Lottery Game!");
		System.out.println("Rules of Game:");
		System.out.println("Choose the 7 numbers between 1 and 39.");
		System.out.println("And Game Begins!");
		drawingOfNumbers();
		enterNum();
		
		System.out.println("Number of Matched: " + matched);
	}

}

