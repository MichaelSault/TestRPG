//maybe change this into an enum?
public class Moves {
	public int selfDamage;
	public int enemyDamage;
	public int selfAttack;
	public int selfDefence;
	public int enemyAttack;
	public int enemyDefence;
	
	//generic getter classes
	public int getDamage() {
		return enemyDamage;
	}
	
	public int getSelfDamage() {
		return selfDamage;
	}
	
	public int getSelfAttack() {
		return selfAttack;
	}
	
	public int getSelfDefence() {
		return selfDefence;
	}
	
	public int getEnemyAttack() {
		return enemyAttack;
	}
	
	public int getEnemyDefence() {
		return enemyDefence;
	}
	
	//generic setter classes
	public void setSelfDamage(int newDamage) {
		selfDamage = newDamage;
	}
	
	public void setEnemyDamage(int newDamage) {
		enemyDamage = newDamage;
	}
	
	public void setSelfAttack(int newAttack) {
		selfAttack = newAttack;
	}
	
	public void setSelfDefence(int newDefence) {
		selfDefence = newDefence;
	}
	
	public void setEnemyAttack(int newAttack) {
		enemyAttack = newAttack;
	}
	
	public void setEnemyDefence(int newDefence) {
		enemyDefence = newDefence;
	}
	
	//move definitions
	public void slash () {
		selfDamage = 0;
		selfAttack = 0;
		selfDefence = 0;
		enemyDamage = 10;
		enemyAttack = 0;
		enemyDefence = 0;
	}
	
	public void intimidate () {
		selfDamage = 0;
		selfAttack = 0;
		selfDefence = 0;
		enemyDamage = 0;
		enemyAttack = -10;
		enemyDefence = -10;
	}
	
	public void brawl () {
		selfDamage = 2;
		selfAttack = 0;
		selfDefence = 0;
		enemyDamage = 10;
		enemyAttack = 0;
		enemyDefence = 0;
	}
}
