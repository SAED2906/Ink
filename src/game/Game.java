package game;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.image.BufferStrategy;

import gfx.Assets;
import input.KeyManager;
import states.State;

public class Game implements Runnable {
	
	private static Display display;
	public int width, height;
	public String title = "title";
	public static String state = "menu";
	public static int ticks = 0;
	
	
	
	static KeyManager keyManager = new KeyManager();
	
	
	
	private Thread thread;
	private boolean running = false;
	
	private Graphics g;

	
	public Game(String title, int width, int height) {
		
		this.width = width;
		this.height = height;
		this.title = title ;
	
	}
	
	private void init() {
		display = new Display(title,width,height);
		//display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
	}
	private void tick() {
		keyManager.tick();
		State.tick();
		
	}
	private void render() {
		display.getFrame().requestFocus();
		
		BufferStrategy bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();

		g.clearRect(0, 0, width, height);
		
		
		
		//Draw------------------------------
		
		
		
		State.render(g);
		
		
		
		
		
		
		//EndDraw----------------------------
		
		
		
		//End Draw
		bs.show();
		g.dispose();
	
		
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			
			now = System.nanoTime();
			delta = delta + ((now - lastTime) / timePerTick);
			timer = timer + (now - lastTime);
			lastTime = now;
			
			
			if (delta >= 1) {
			tick();
			render();
			ticks++;
			delta--;
			}
			
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: "+ ticks);
				ticks = 0;
				timer = 0;
				
				
			}
		}
		stop();
	}
	
	public static KeyManager getKeyManager() {
		return keyManager;
	}
	
	
	public static Display getdisplay() {
		return display;
	}
	
	public static String getState() {
		return state;
	}
	
	public static void setState(String s) {
		state = s;
	}
	
	
	public synchronized void start() {
		if (running) 
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop() {
		if (!running) 
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}