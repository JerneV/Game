package jernev;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import entity.Bullet;
import entity.Entity;
import entity.Mob;
import entity.Player;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public final int width = 1024;
	public final int height = 786;
	public static int px = 0;
	public static int py = 0;
	public static GamePanel gPanel = new GamePanel();
	public static Player player = new Player(null);
	public static Bullet bullet = new Bullet();
	public static Mob mob;
	public Entity entity;

	boolean isRunning = true;
	public static boolean debugEnabled = false;
	int fps = 30;
	public InputHandler input = new InputHandler(this);

	BufferedImage backBuffer;
	Insets insets;

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
		System.exit(0);
	}

	public void run() {
		initialize();

		while (isRunning) {
			long time = System.currentTimeMillis();

			update();
			draw();

			// delay for each frame - time it took for one frame
			time = 1000 / fps - (System.currentTimeMillis() - time);

			if (time > 0)
				try {
					Thread.sleep(time);
				} catch (Exception e) {
				}
		}

		setVisible(false);
	}

	void initialize() {
		setTitle("Jerne Shoot");
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		insets = getInsets();
		// setSize(insets.left + width + insets.right, insets.top + height +
		// insets.bottom);
		backBuffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}

	void update() {
		if (!player.removed) {

			if (input.isKeyDown(KeyEvent.VK_RIGHT))
				if (Player.px < 954) {
					px = 3;
					player.setDirection(1);
				}
			if (input.isKeyDown(KeyEvent.VK_LEFT))
				if (Player.px > 35) {
					px = -3;
					player.setDirection(3);
				}
			if (input.isKeyDown(KeyEvent.VK_UP))
				if (Player.py > 36) {
					py = -3;
					player.setDirection(0);
				}
			if (input.isKeyDown(KeyEvent.VK_DOWN))
				if (Player.py < 696) {
					py = 3;
					player.setDirection(2);
				}

			// SPECIAL INPUTS
			// 0 NORTH, 1 EAST, 2 SOUTH, 3 WEST; 4 NE, 5
			// SE, 6 SW, 7 NW

			if (input.isKeyDown(KeyEvent.VK_UP) && input.isKeyDown(KeyEvent.VK_LEFT)) { // NW
				if (Player.py > 36 && Player.px > 35) {
				px = -3;
				py = -3;
				player.setDirection(7);
				}
			}
			if (input.isKeyDown(KeyEvent.VK_RIGHT) && input.isKeyDown(KeyEvent.VK_DOWN)) { // SE
				if(Player.px > 35 && Player.py < 696){
				px = 3;
				py = 3;
				player.setDirection(5);
				}
			}
			if (input.isKeyDown(KeyEvent.VK_DOWN) && input.isKeyDown(KeyEvent.VK_LEFT)) { // SW
				if (Player.py < 696 && Player.px > 35) {
				px = -3;
				py = 3;
				player.setDirection(6);
				}
			}
			if (input.isKeyDown(KeyEvent.VK_RIGHT) && input.isKeyDown(KeyEvent.VK_UP)) { // NE
				if (Player.px < 954 && Player.py > 36) {
				px = 3;
				py = -3;
				player.setDirection(4);
				}
			}
			if(input.isKeyDown(KeyEvent.VK_SPACE)){
				if(bullet.lastTimeShot == 0){
				bullet.lastTimeShot = 50;
				bullet.shoot(player.getDirection());
				}
			}

			player.tick();
			bullet.tick();

		}
		if (input.isKeyDown(KeyEvent.VK_F3))
			if (!debugEnabled)
				debugEnabled = true;
			else
				debugEnabled = false;

	}

	void draw() {
		Graphics g = getGraphics();
		Graphics bbg = backBuffer.getGraphics();

		bbg.setColor(Color.WHITE); // Makes background white
		bbg.fillRect(0, 0, width, height);
		gPanel.drawBorders(bbg, Color.BLACK);

		player.render(gPanel, bbg);
		bullet.render(gPanel, bbg);
		g.drawImage(backBuffer, insets.left, insets.top, this);
	}
}