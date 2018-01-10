
public class Character {
	private String name;	//character name
	private int level;	//character level
	private double exp;
	private int health;
	private int maxHealth;
	private int attack;
	private int defence;
	private int enemiesDefeted;

	public Character(){
		name = "player";
		level = 1;
		exp = 0;
		health = 100;
		maxHealth = 100;
		attack = 20;
		defence = 20;
		enemiesDefeted = 0;
	}
	public Character(String character, int lvl, double xp, int hp, int mHP, int att, int def, int count) {
		name = character;
		level = lvl;
		exp = xp;
		health = hp;
		maxHealth = mHP;
		attack = att;
		defence = def;
		enemiesDefeted = count;
	}
	
	//setter classes defined here
	public void setName(String character) {
		name = character;
	}
	public void setLevel(int lvl) {
		level = lvl;
	}
	public void setEXP(double xp) {
		exp = xp;
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
	public void setEnemiesDefeted(int count) {
		enemiesDefeted = count;
	}
	
	//getter classes defined here
	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public double getEXP() {
		return exp;
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
	public int getEnemiesDefeted() {
		return enemiesDefeted;
	}
	
	//Status classes
	public void levelUp() {
		level++;
	}
	public void levelDown() {	//maybe used for temporary items/pots?
		level--;
	}
	public void earnEXP(double xp) {
		exp += xp;
	}
	public void loseEXP(double xp) {
		exp -= xp;
	}
	public void heal(int healBack) {
		health += healBack;
	}
	public void damaged(int damage) {
		health -= damage;
	}
	public void HPup(int statpoints) {
		maxHealth += statpoints;
	}
	public void ATTup(int statpoints) {
		attack += statpoints;
	}
	public void DEFup(int statpoints) {
		defence += statpoints;
	}
	public void enemyKilled() {
		enemiesDefeted++;
	}
}
