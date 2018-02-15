package jernev;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public boolean[] keys = new boolean[256];

	public InputHandler(Component c) {
		c.addKeyListener(this);
	}

	/**
	 * Checks whether a specific key is down
	 * 
	 * @param keyCode
	 *            The key to check
	 * @return Whether the key is pressed or not
	 */
	public boolean isKeyDown(int keyCode) {
		if (keyCode > 0 && keyCode < 256)
			return keys[keyCode];

		return false;
	}

	/**
	 * Called when a key is pressed while the component is focused
	 * 
	 * @param e
	 *            KeyEvent sent by the component
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
			keys[e.getKeyCode()] = true;
	}

	/**
	 * Called when a key is released while the component is focused
	 * 
	 * @param e
	 *            KeyEvent sent by the component
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
			keys[e.getKeyCode()] = false;
	}

	/**
	 * Not used
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}
}
