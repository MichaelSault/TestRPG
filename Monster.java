import java.util.Random;

public class Monster {
	private String[] enemies;	//monsters available to spawn
	private String monsterName;
	private int maxHealth;
	private int health;
	private int attack;
	private int defence;
	private int persistence;
	private int exp;
	Random rand = new Random();	//new random object (random number)
	
	public Monster() {
		enemies = null;
		monsterName = null;
		maxHealth = 0;
		health = 0;
		attack = 0;
		defence = 0;
		persistence = 0;
		exp = 0;
	}
	public Monster(String[] mobs, int mHP, int HP, int ATT, int DEF, int PER) {
		enemies = mobs;
		monsterName = enemies[rand.nextInt(enemies.length)];
		maxHealth = mHP;
		health = HP;
		attack = ATT;
		defence = DEF;
		persistence = PER;
		exp = (mHP+ATT+DEF)*(PER/10);
	}
	
	//setter classes defined here
	public void setEnemiesList(String[] enems) {
		enemies = enems;
	}
	public void setMonster(String mon) {
		monsterName = mon;
	}
	public void setHP(int hp) {
		health = hp;
	}
	public void setMHP(int mHP) {
		maxHealth = mHP;
	}
	public void setATT(int att) {
		attack = att;
	}
	public void setDEF(int def) {
		defence = def;
	}
	public void setPers(int pers) {
		persistence = pers;
	}
	public void setExp(int xp) {
		exp = xp;
	}
	
	//getter classes defined here
	public String[] getEnemiesList() {
		return enemies;
	}
	public String getMonster() {
		return monsterName;
	}
	public int getHP() {
		return health;
	}
	public int getMHP() {
		return maxHealth;
	}
	public int getATT() {
		return attack;
	}
	public int getDEF() {
		return defence;
	}
	public int getPers() {
		return persistence;
	}
	public int getExp() {
		return exp;
	}
	
	//stat buff/debuff classes
	public void damaged(int HP) {
		health -= HP;
	}
	public void heal(int HP) {
		health += HP;
	}
	public void weaken(int stat) {
		attack -= stat;
	}
	public void buff(int stat) {
		attack += stat;
	}
	public void lure(int stat) {
		defence -= stat;
	}
	public void onGuard(int stat) {
		defence += stat;
	}
	public void distracted(int stat) {
		persistence -= stat;
	}
	public void focused(int stat) {
		persistence += stat;
	}
	public void lucky(int multiplier) {
		exp*=multiplier;
	}
	public void unlucky(int multiplier) {
		exp/=multiplier;
	}
}