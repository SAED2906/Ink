package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

public class KeyManager implements KeyListener {
	
	
	private boolean[] keys;
	public boolean up, down, left, right, space, m1;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		space = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			System.out.println("Yes");
			
		}
		keys[e.getKeyCode()] = true;
		System.out.println("Pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

}
