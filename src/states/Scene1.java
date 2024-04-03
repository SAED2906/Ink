package states;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;

import audio.AudioMain;
import game.Game;
import gfx.Assets;
import gfx.Camera;
import gfx.object;


public class Scene1 {
	
	static ArrayList<object> objects = new ArrayList<object>();
	static boolean initialised = false;
	static boolean audio_running = false;

	static int counter = 0;
	static int x = 0;
	static boolean isJump = false;
	static boolean falling = true;
	
	private static float gravity = 0.5f;
	
	static boolean inbounds = true;
	
	///player
	
	static float velX = 0.5f;
	static float velY = 0.5f;
	
	
	static int xLoc = 1920/2;
	static int yLoc = 1080/2;

	public static void init() {
		// Add objects to object list
		objects.add(new object(Assets.camp, 100, 100, 30, 40, "camp"));
	}
	
	
	///
	
	public static void render(Graphics g) {
		if (!initialised) {
			initialised = true;
			init();
			return;
		} 
		//g.setColor(Color.black);
		//g.fillRect(0, 980, 1920, 100);
	
		
		for (object object : objects) {
			//System.out.println((object.x - xLoc) + " " + (object.y - yLoc));
			g.drawImage(object.texture, (object.x - xLoc), (object.y - yLoc), object.width, object.height, null);
		}
	
		
		//g.fillRect(xLoc, yLoc, 100, 100);
		g.drawImage(Assets.ink, 1920/2, 1080/2, 100, 100, null);
		
		
		

	
	}	

	public static void tick() {
		
		//Camera.tick();
		//xLoc += velX;
		//yLoc += velY;
		inBounds();

		getInput();

		if (!audio_running) {
			Thread audio = new Thread(new audio());
			audio_running = true;
			audio.setDaemon(true);
			audio.start();
			
		}
		
		
		// if (falling && inBounds()) {
		// 	yLoc += velY;
		// 	//System.out.println(inBounds());
		// 	velY += gravity;
		// }
	}
	
	
	
	
	
	private static void getInput() {
		
		if(Game.getKeyManager().space || Game.getKeyManager().up) {
			yLoc = Math.round(yLoc - 10*velY);
		}
		if(Game.getKeyManager().shift || Game.getKeyManager().down) {
			yLoc = Math.round(yLoc + 10*velY);
		}
		
		if(Game.getKeyManager().right) {
			xLoc= Math.round(xLoc + 10*velX);
		}
		if(Game.getKeyManager().left) {
			xLoc= Math.round(xLoc - 10*velX);
		}

	}

	static class audio implements Runnable{
		public audio() {

		}

		@Override
		public void run() {
			try {
				AudioMain.playL("src/audio/wind1.wav");
				//Thread.sleep(99*1000);
			} catch (LineUnavailableException | AWTException e) {
				e.printStackTrace();
			}
			audio_running = false;
		}
	}
	
	
	
	
	
	public static boolean inBounds() {
		
		//System.out.println(inbounds);
		if (yLoc > 880) {
			inbounds = false;
			yLoc = 880;
		}
		
		if (yLoc < 880) {
			inbounds = true;
		}
		
		
		return inbounds;
	}

	public static void inview() {

	}
	
	

}
