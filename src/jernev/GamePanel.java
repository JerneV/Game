package jernev;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import entity.Entity;
import entity.EnumDirection;
import entity.Player;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public static EnumDirection dir = new EnumDirection();

	public void drawBorders(Graphics g, Color color) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		g2d.fillRect(0, 0, 1024, 35); // TOP
		g2d.fillRect(0, 725, 1024, 35); // BOTTOM
		g2d.fillRect(0, 0, 35, 786); // LEFT
		g2d.fillRect(985, 0, 35, 786); // RIGHT
		// System.out.println("Drew floor");

	}

	public void drawText(Graphics g, int x, int y, boolean isBold, Color color, String text)
			throws IllegalArgumentException { // a function to draw strings on
												// the JPanel
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(color);
		if (isBold) {
			final Font font = new Font("Verdana", Font.BOLD, 12);
			g2d.setFont(font);
		} else {
			final Font font = new Font("Verdana", Font.PLAIN, 12);
			g2d.setFont(font);
		}

		g2d.drawString(text, x, y);

	}

	public void render(int x, int y, Entity entity, Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (Main.debugEnabled) {
			drawText(g2d, x, y - 10, true, Color.BLACK, Integer.toString(Player.px));
			drawText(g2d, x + 35, y - 10, true, Color.BLACK, Integer.toString(Player.py));
		}
		if (entity.isPlayer()) { // Check if the entity is a player
			g2d.setColor(Color.BLACK);
			g2d.drawOval(x, y, 30, 30);
			g2d.drawOval(x + 15, y + 15, 1, 1); // Center point
			// double dir = entity.getDirection(); //get direction //0 NORTH, 1
			// EAST, 2 SOUTH, 3 WEST; 0.5 NE, 1.5 SE, 2.5 SW, 3.5 NW

			// EnumDirection playerdir = dir.getDir();
			// drawText(g2d, x+15, y+45, true, Color.CYAN,
			// playerdir.toString());
			// drawText(g2d, x, y-10, true, Color.GREEN, "Rendered player
			// circle");
		}
		if(entity.entityNumber() == 1){ //Is bullet
			g2d.setColor(Color.RED);
			g2d.drawOval(x, y, 8, 8);
		}

	}

}
