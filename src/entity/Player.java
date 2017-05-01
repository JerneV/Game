package entity;

import java.awt.Graphics;
import jernev.GamePanel;

import jernev.Main;

public class Player extends Mob {

	static Main main = new Main();
	public static int px = main.width/2;
	public static int py = main.height/2;

	
	public Player(Object object) {
		
	}

	public void tick(){
	 	px += Main.px;
		py += Main.py;
		Main.px = 0;
		Main.py = 0;
	}
	 
	
	public void render(GamePanel gPanel, Graphics g){
		//System.out.println("Called player render with x: " + px + " and y: " + py);
		isPlayer = true;
		gPanel.render(px, py, this, g);
	}
	
	
	
}
