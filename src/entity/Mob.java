package entity;

public class Mob extends Entity{
	public int maxHealth = 10;
	public int health = maxHealth;
	
	
	public void tick(){
		if (health <= 0) die();
	}


	private void die() {
		remove();
	}
	
	
}
