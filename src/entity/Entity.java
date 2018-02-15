package entity;

import java.awt.Graphics;

import jernev.GamePanel;

public class Entity {
	public GamePanel gPanel;
	public boolean removed = false;
	protected boolean isPlayer = false;
	protected int entityNumber;
	protected int direction; // 0 NORTH, 1 EAST, 2 SOUTH, 3 WEST; 4 NE, 5
								// SE, 6 SW, 7 NW

	public void render(GamePanel gPanel, Graphics g) { // Render function

	}

	public void tick() { // Ticks the entity

	}

	public void hurt(Mob mob, int dmg) {
		if (mob == null)
			throw new IllegalArgumentException("Entity cannot be damaged by nothing");
	}

	public void remove() {
		removed = true;
	}

	public boolean isPlayer() { // Differtiate between normal mobs and player
		return isPlayer;
	}

	public void setIsPlayer() {
		isPlayer = true;
	}

	public int entityNumber() { // When not player differentiate between mobs
		return entityNumber;
	}

	public void setEntityNumber(int number) {
		entityNumber = number;
	}

	public void setDirection(int dir) { // 0 NORTH, 1 EAST, 2 SOUTH, 3 WEST; 4 NE, 5
										   // SE, 6 SW, 7 NW
		direction = dir;
	}

	public int getDirection() { // 0 NORTH, 1 EAST, 2 SOUTH, 3 WEST; 4 NE, 5
								  // SE, 6 SW, 7 NW
		return direction;
	}

}
