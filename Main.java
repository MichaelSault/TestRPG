import java.util.Random;
import java.util.Scanner;


public class main {
	public static void main(String [] args) {
		Random rand = new Random();	//random number user for combat later

		String charName = welcome();
		
		System.out.println(charName);


	}
	
	public static String welcome() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	//for user input
		
		//dialog to create the user profile
		System.out.println("\t#Hello and welcome to the world of Pokemon!#");
		System.out.println("\n\tuhhh... I mean Text RPG!");
		
		System.out.println("\n\tPlease, tell me your name: ");
		String charName = in.nextLine();
		
		System.out.println("\n\t#Welcome to the game " + charName + "! Please enjoy your stay!#");
		
		return charName;
	}
	
	
}
