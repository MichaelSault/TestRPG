
public class Monster {
	private String[] enemies;	//monsters available to spawn
	private int maxHealth;
	private int health;
	private int attack;
	private int defence;
	private int persistence;
	
	public Monster() {
		enemies = null;
		maxHealth = 0;
		health = 0;
		attack = 0;
		defence = 0;
		persistence = 0;
	}
	public Monster(String[] mobs, int mHP, int HP, int ATT, int DEF, int PER) {
		enemies = mobs;
		maxHealth = mHP;
		health = HP;
		attack = ATT;
		defence = DEF;
		persistence = PER;
	}
	
	//setter classes defined here
	public void setEnemiesList(String[] enems) {
		enemies = enems;
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
	
	//getter classes defined here
	public String[] getEnemiesList(String[] enems) {
		return enemies;
	}
	public int getHP(int hp) {
		return health;
	}
	public int getMHP(int mHP) {
		return maxHealth;
	}
	public int getATT(int att) {
		return attack;
	}
	public int getDEF(int def) {
		return defence;
	}
	public int getPers(int pers) {
		return persistence;
	}
	
	//stat buff/debuff classes
	public void Damaged(int HP) {
		health -= HP;
	}
	public void Heal(int HP) {
		health += HP;
	}
	public void Weaken(int stat) {
		attack -= stat;
	}
	public void Buff(int stat) {
		attack += stat;
	}
	public void Lure(int stat) {
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
}
