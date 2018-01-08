import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//system objects
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	//new scanner (user input)
		Random rand = new Random();	//new random object (random number)
		
		//Game variables			-> 	moved to an enemy class
		String[] enemies = {"Goblin", "Bat", "Evil Pupper"};
		int maxEnemyHealth = 102;
		int maxEnemyAttackDamage = 25;
		int maxEnemyPersistence = 70;
		int enemiesDefeted = 0;	//moved to Character class now
		
		//Character variables	-> 	all moved to character class now
		int health = 100;
		int attackDamage = 50;
		int numHealthPots = 5;
		int healthPotsHealAmounts = 30;
		int healthPotDropChance = 40;	//is a percentage
		
		boolean running = true;	//probably wont be needed right?
		
		System.out.println("Prepare yourself for you have entered the dungeon.");
		
		GAME:	//label to iterate the while loop
		while(running) {
			System.out.println("-------------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# " + enemy + " appeared! #\n");
			
			while(enemyHealth > 0) {
				System.out.println("\tYour HP: " + health);
				System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
				System.out.println("\n\tWhat will you do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Flee!");
				
				String input = in.nextLine();
				if (input.equals("1")) {
					int damageDealt = rand.nextInt(attackDamage);	//for the combat class
					int damageTaken = rand.nextInt(maxEnemyAttackDamage);		//for the combat class
					
					enemyHealth = enemyHealth - damageDealt;	//for the combat class
					health = health - damageTaken;	//for the combat class
					
					System.out.println("\tYou hit the " + enemy + " for " + damageDealt + " damage!");
					System.out.println("\tThe " + enemy + " strikes back any you take " + damageTaken + " damage!");
					
					if (health <= 0){
						System.out.println("\t#You have sustained too much damage.. you have died...#");
						break;
					}
					
				} else if (input.equals("2")) {
					if (numHealthPots > 0) {
						health += healthPotsHealAmounts;
						numHealthPots--;
						System.out.println("\t#You drink a health potion and heal yourself for " + healthPotsHealAmounts + "!"
								+ "\n\t#You now have " + health + " HP."
								+ "\n\t#You now have " + numHealthPots + " health potions remaining in your inventory.");
					} else {
						System.out.println("You don't have any health potions left! Loot them from mobs you defete in battle!");
					}
					
				} else if (input.equals("3")) {
					int enemyPersistence = rand.nextInt(maxEnemyPersistence);
					System.out.println("You have a " + enemyPersistence + "% chance of failure, try anyways?");
					System.out.println("Y/N");
					String flee = in.nextLine();
					if (flee.equals("Y")) {
						int fleeRate = rand.nextInt(100);
						if (fleeRate > enemyPersistence) {
							System.out.println("You have flee'd from the mob!");
							continue GAME;	//starts game from the label Game;
						} else {
							System.out.println("You attempted to flee but the moster caught up to you.");
							int damageTaken = rand.nextInt(maxEnemyAttackDamage);
							health = health - damageTaken;
							System.out.println("\tThe " + enemy + " strikes you across the back, you take " + damageTaken + " damage!");
						}
					} else if (flee.equals("N")){
						break;
					} else {
						System.out.println("Invalid input!");
					}
				} else {
					System.out.println("Invalid input!");
				}
			}
			if (health < 1) {
				System.out.println("You have been defeted in battle.. game over");
				System.out.println("Score: " + enemiesDefeted*500 + " points");
				break;
			}
			System.out.println("-------------------------------------------------");
			System.out.println("\t# " + enemy + " was defeted! # ");
			enemiesDefeted++;
			if(rand.nextInt(100) < healthPotDropChance) {
				numHealthPots++;
				System.out.println("\tYou looted a health potion from the " + enemy + "!");
				System.out.println("\tYou have " + numHealthPots + " health potion(s)!");
			}
			System.out.println("-------------------------------------------------");
			System.out.println("\n\tWhat will you do now player?");
			System.out.println("\t1. Continue fighting");
			System.out.println("\t2. Look for the exit");
			
			String input = in.nextLine();
			while (!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid input!");
				input = in.nextLine();
			}
			if (input.equals("1")){
				System.out.println("You continue furture into the dungeon...");
			} else if (input.equals("2")) {
				System.out.println("You have exited the dungeon.. you win!");
				System.out.println("Score: " + ((enemiesDefeted*1000)+(health*500)) + " points");
				break;
			}
		}
	}
}
