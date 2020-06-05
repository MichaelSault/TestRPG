import java.util.Random;
import java.util.Scanner;


public class main {
	
	//use for now, maybe create a doublearray or hashmap later?
	//moveID, moveName, selfDamage, enemyDamage, selfAttack, enemyAttack, selfDefence, enemyDefence
	static Moves [] movesList = new Moves [] {
			new Moves(1, "slash", 0, 10, 0, 0, 0, 0),
			new Moves(2, "block", 0, 0, 0, 0, 10, 0),
			new Moves(3, "intimidate", 0, 0, 0, -10, 0, -10),
			new Moves(4, "life steal", -5, 10, 0, 0, 0, 0),
			new Moves(5, "size up", 0, 0, 10, 0, 0, 0),
			new Moves(6, "throw sand", 0, 5, 0, 0, 0, -10),
			new Moves(7, "sheild break", 0, 0, 0, 0, 0, -20),
			new Moves(8, "raise guard", 0, 0, 0, 0, 20, 0),
			new Moves(9, "1 inch punch", 0, 20, 0, 0, 0, 0),
			new Moves(10, "final flash!", 0, 50, -10, 0, -10, 0) //does a ton of damage but lowers all stats.  an end game move probably
	};
	
	// declare monster groups
	static String[] tutorialMonsters = {"Bush Wolf"};
	static String[] forestMonsters = {"Goblin", "Bat", "Wolf"};

	//mobs, mHP, HP, ATT, DEF, PER
	static Monster [] monstersList = new Monster [] {
			new Monster(tutorialMonsters, 50, 50, 10, 10, 100), //100 persistence so you can't flee
			new Monster(forestMonsters, 60, 60, 10, 10, 10)
	};
		
	public static void main(String [] args) {
		String charName = welcome();
		Character player = new Character();
		player.setName(charName);
				
		tutorialForest(player);
		
		//System.out.println(movesList[3].getMoveName());


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


	public static void tutorialForest(Character player) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	//for user input
		
		Random rand = new Random();	//random number user for combat later
		
		boolean running = true;	//to run a simple loop
		System.out.println("\t#I hope you're ready, you're about to enter area 1: The Forest#");
		System.out.println("|-----------------------------------------------------------------------|");
		System.out.println("\tYou enter the forest and begin to look around and take in your suroundings.");
		System.out.println("\tYou can hear rustling in and about the surounding bush."
				+ "\n\tAfter listening for a couple moments, you determine the sound is getting closer.");
		System.out.println("\tEquiped with a rusty sword you feel like you can likely hold your own"
				+ "\n\tagaint the source of the sound.  However you're not sure for how long.");
		System.out.println("|-----------------------------------------------------------------------|");
		System.out.println("\t##COMBAT HAS BEGUN##");
		int areaID = 1;

		FOREST:
		while (running) {
			Monster forestMonster = new Monster(monstersList[areaID].getEnemiesList(), monstersList[areaID].getMHP(), monstersList[areaID].getHP(), monstersList[areaID].getATT(), monstersList[areaID].getDEF(), monstersList[areaID].getPers());

			System.out.println("|-----------------------------------------------------------------------|");
			System.out.println("\t#A " + forestMonster.getMonster() + " jumps out from the bush!#");
			
			while(forestMonster.getHP() > 0) {
				System.out.println("\tYour HP: " + player.getHP() + "/" + player.getMHP());
				System.out.println("\t" + forestMonster.getMonster() + "'s HP: " + forestMonster.getHP());
				System.out.println("\n\tWhat will you do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Flee!");
				
				String input = in.nextLine();
				
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
				
				if (flee.equals("Y")||flee.equals("y")) {
					int fleeRate = rand.nextInt(100);
					if (fleeRate > enemyPersistence) {
						System.out.println("You have flee'd from the mob!");
						String areaFlee = "p";
						while((!areaFlee.equals("Y"))&&(!areaFlee.equals("y"))&&(!areaFlee.equals("N"))&&(!areaFlee.equals("n"))) {
							System.out.println("Would you like to retire?");
							System.out.println("Y/N");
							areaFlee = in.nextLine();
							if (areaFlee.equals("Y")||areaFlee.equals("y")) {
								retire(player);
								return;
							} else if (areaFlee.equals("N")||areaFlee.equals("n")) {
								continue FOREST;	//starts game from the label FOREST;
							} else System.out.println("\t#INVALID INPUT#");
						}
						
					} else {
						System.out.println("You attempted to flee but the moster caught up to you.");
						int damageTaken = rand.nextInt(forestMonster.getATT());
						player.damaged(damageTaken);
						System.out.println("\tThe " + forestMonster.getMonster() + " strikes you across the back, you take " + damageTaken + " damage!");
					}
				} else if (flee.equals("N")||flee.equals("n")){
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
		
		String input = in.nextLine();
		
		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("\t#INVALID INPUT#");
			input = in.nextLine();
		}
		
		if (input.equals("1")) {
			continue FOREST;
		} else if (input.equals("2")) {
			retire(player);
			return;
		}
	}
	}
	
	public static void retire(Character player) {
		System.out.println("\t#You decide to leave the forest and retire. Congratulations!#");
		System.out.println("\t Score: " + (player.getEnemiesDefeted()*1000)*(player.getHP()/10) + " points");
	}
}
