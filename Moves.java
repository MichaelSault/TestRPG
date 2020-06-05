//maybe change this into an enum?
public class Moves {
	private int moveID;
	private String moveName;
	private int selfDamage;
	private int enemyDamage;
	private int selfAttack;
	private int selfDefence;
	private int enemyAttack;
	private int enemyDefence;
	
	
	public Moves() {
		moveID = 0;
		moveName = null;
		selfDamage = 0;
		enemyDamage = 0;
		selfAttack = 0;
		enemyAttack = 0;
		selfDefence = 0;
		enemyDefence = 0;
	}
	
	public Moves(int moveID_in, String moveName_in, int selfDamage_in, int enemyDamage_in, int selfAttack_in, int enemyAttack_in, int selfDefence_in, int enemyDefence_in) {
		moveID = moveID_in;
		moveName = moveName_in;
		selfDamage = selfDamage_in;
		enemyDamage = enemyDamage_in;
		selfAttack = selfAttack_in;
		enemyAttack = enemyAttack_in;
		selfDefence = selfDefence_in;
		enemyDefence = enemyDefence_in;
	}
	
	//generic getter classes
	public int getMoveID() {
		return moveID;
	}
	
	public String getMoveName() {
		return moveName;
	}
	
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
	public void setMoveID(int newMoveID) {
		moveID = newMoveID;
	}
	
	public void setMoveName(String newMoveName) {
		moveName = newMoveName;
	}
	
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
}
