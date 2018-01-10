import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
			//system objects
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);	//new scanner (user input)
			Random rand = new Random();	//new random object (random number)
			
			//step one, create a new character profile
			System.out.println("\t#Hello and welcome to TextRPG#");
			System.out.println("\n\tPlease enter your name to begin:");
			String input = in.nextLine();
			System.out.println("\n\t#Welcome to the game " + input +"!#");
			Character player = new Character();
			player.setName(input);
			
			//step two, have the player enter the forest
			boolean running = true;	//to run a simple loop
			String[] forestMonsters = {"Goblin", "Bat", "Wolf"};	//monsters available to fight
			String monster = null;
			System.out.println("\t#I hope you're ready, you're about to enter area 1: The Forest#");
			System.out.println("|-----------------------------------------------------------------------|");
			System.out.println("\tYou enter the forest and begin to look around and take in your suroundings.");
			System.out.println("\tYou can hear rustling in and about the surounding bush."
					+ "\n\tAfter listening for a couple moments, you determine the sound is getting closer.");
			System.out.println("\tEquiped with a rusty sword you feel like you can likely hold your own"
					+ "\n\tagaint the source of the sound.  However you're not sure for how long.");
			System.out.println("|-----------------------------------------------------------------------|");
			System.out.println("\t##COMBAT HAS BEGUN##");
			
			FOREST:
			while (running) {
				Monster forestMonster = new Monster(forestMonsters, 60, 60, 10, 10, 10);
				System.out.println("|-----------------------------------------------------------------------|");
				System.out.println("\t#A " + forestMonster.getMonster() + " jumps out from the bush!#");
				
				while(forestMonster.getHP() > 0) {
					System.out.println("\tYour HP: " + player.getHP() + "/" + player.getMHP());
					System.out.println("\t" + forestMonster.getMonster() + "'s HP: " + forestMonster.getHP());
					System.out.println("\n\tWhat will you do?");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Drink health potion");
					System.out.println("\t3. Flee!");
					
					input = in.nextLine();
					
					if (input.equals("1")) {
						int damageDealt = rand.nextInt(player.getATT());
						int damageTaken = rand.nextInt(forestMonster.getATT());
						
						forestMonster.damaged(damageDealt);
						player.damaged(damageTaken);
						
						System.out.println("\tYou hit the " + forestMonster.getMonster() + " for " + damageDealt + " damage!");
						System.out.println("\tThe " + forestMonster.getMonster() + " strikes back any you take " + damageTaken + " damage!");
						
						if (player.getHP() <= 0){
							System.out.println("\t#You have sustained too much damage.. you have died...#");
							break;
						}
				} else if (input.equals("2")) {
					System.out.println("\t#Inventory system not yet implemented#");
				} else if (input.equals("3")) {
					int enemyPersistence = rand.nextInt(forestMonster.getPers());
					System.out.println("You have a " + enemyPersistence + "% chance of failure, try anyways?");
					System.out.println("Y/N");
					String flee = in.nextLine();
					if (flee.equals("Y")) {
						int fleeRate = rand.nextInt(100);
						if (fleeRate > enemyPersistence) {
							System.out.println("You have flee'd from the mob!");
							continue FOREST;	//starts game from the label FOREST;
						} else {
							System.out.println("You attempted to flee but the moster caught up to you.");
							int damageTaken = rand.nextInt(forestMonster.getATT());
							player.damaged(damageTaken);
							System.out.println("\tThe " + forestMonster.getMonster() + " strikes you across the back, you take " + damageTaken + " damage!");
						}
					} else if (flee.equals("N")){
						break;
					} else {
						System.out.println("\t#INVALID INPUT#");
					}
				}	
			}
			if (player.getHP() < 1) {
				System.out.println("\t#You have been defeted in battle.. game over#");
				System.out.println("\t Score: " + player.getEnemiesDefeted()*500 + " points");
				break;
			}
			System.out.println("-------------------------------------------------");
			System.out.println("\t# " + forestMonster.getMonster() + " was defeted! # ");
			player.enemyKilled();
			System.out.println("\tWould you like to continue into the forest or turn back and retire?");
			System.out.println("\t1. Continue");
			System.out.println("\t2. Retire");
			
			input = in.nextLine();
			
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("\t#INVALID INPUT#");
				input = in.nextLine();
			}
			
			if (input.equals("1")) {
				continue FOREST;
			} else if (input.equals("2")) {
				System.out.println("\t#You decide to leave the forest and retire. Congratulations!#");
				System.out.println("\t Score: " + (player.getEnemiesDefeted()*1000)*(player.getHP()/10) + " points");
				break;
			}
			
		}
	}
}
