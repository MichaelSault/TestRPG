import java.util.Scanner;
import java.util.Random;

public class StaticCity {
	
	boolean intown = true;
	//system objects
			Scanner in = new Scanner(System.in);	//new scanner (user input)
			Random rand = new Random();	//new random object (random number)
			
	public StaticCity() {	//intro info text for Static City
		System.out.println("-------------------------------------------------");
		System.out.println("You find yourself in Static City.");
		System.out.println("It is a rather small city located on the edge of a small forest.");
		System.out.println("You notice 2 distinct buildings, a quiet Inn that doesn't seem to see much buisness, "
				+ "\nand a general store, well know for it's low level healing potions.");
		System.out.println("There is a path leading north into a forest and another leading west to what looks like a"
				+ "\nsmall pond.");
		System.out.println("Additionally, you notice that a number of people gathered in the town square");
		
		System.out.println("\n");
		System.out.println("\n\tWhat would you like to do?");
		System.out.println("\t1. Check out the Inn");
		System.out.println("\t2. Check out the Shop");
		System.out.println("\t3. Walk into the town square");
		System.out.println("\t4. Head north into the forest");
		System.out.println("\t5. Head west to the edge of the pond");
		
		String input = in.nextLine();
		if (input.equals("1")) {
			Inn();
		} else if (input.equals("2")) {
			Shop();
		} else if (input.equals("3")) {
			TownSquare();
		} else if (input.equals("4")) {
			Forest();
		} else if (input.equals("5")) {
			Pond();
		} else {
			System.out.println("Invalid input!");
		}
	}
	public void Inn(){	//used to heal -->currently free but will cost gold later
		
	}
	public void Shop(){	//buy items --> need to implement gold
		
	}
	public void TownSquare(){	//talk to NPCs	-->	get info
		
	}
	public void Forest(){	//advance to dungeon 1
		
	}
	public void Pond(){		//small side area	-->	extra loot maybe?
		
	}
}
