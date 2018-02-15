package entity;

import java.awt.Graphics;

import jernev.GamePanel;

public class Bullet extends Entity {
	int x, y; // LOCATION
	int dx, dy; // ACCELERATION
	int bulletSpeed = 5;
	public int lastTimeShot = 0; //Time since last shot

	@Override
	public void tick() {
		x += dx;
		y += dy;
		if(lastTimeShot > 0) lastTimeShot--;
	}
	
	
	public void shoot(int direction) {
		switch(direction){
		case(0):
			dy = bulletSpeed;
			break;
		case(1):
			dx = bulletSpeed;
			break;
		case(2):
			dy = -bulletSpeed;
			break;
		case(3):
			dx = -bulletSpeed;
			break;
		case(4):
			dx = bulletSpeed;
			dy = bulletSpeed;
			break;
		case(5):
			dx = bulletSpeed;
			dy = -bulletSpeed;
			break;
		case(6):
			dx = -bulletSpeed;
			dy = -bulletSpeed;
			break;
		case(7):
			dx = -bulletSpeed;
			dy = bulletSpeed;
			break;
		default:
			throw new UnsupportedOperationException("Unknown direction input!");
		}
		
		
	}
	
	@Override
	public void render(GamePanel gPanel, Graphics g) {
		this.setEntityNumber(1);
		gPanel.render(x, y, this, g);
	}

	

}
