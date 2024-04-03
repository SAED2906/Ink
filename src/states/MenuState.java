package states;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;

import javax.sound.sampled.LineUnavailableException;

import audio.AudioMain;
import backgrounds.Background;
import game.Game;
import gfx.Assets;
import gfx.Camera;

public class MenuState {
	
	static float timestamp = 0;
	static float timestamp2 = 0;
	static boolean temp = false; 
	static int Opacity = 0;
	
	public static void render(Graphics g) {
		
		Background.render(g);
		g.drawImage(Assets.TC, 0, 0, null);
		g.drawImage(Assets.T, 0, 0, null);
		
		if (temp == true) {
			Finalrender(g);
		}
		
	}
	
	public static void Finalrender(Graphics g) {
		
		int alpha = Opacity; // 50% transparent
		Color myColor = new Color(255, 255, 255, alpha);
		
		
		g.setColor(myColor);
		g.fillRect(0, 0, 1920, 1080);
		
		
		if (!(Opacity >= (252))) {
		
		Opacity = Opacity + 7;
		
		}else {
			Opacity =254;
		}
	
	}
	
	
	
	public static void tick() {
		Camera.tick();
		getInput();
	}
	
	private static void getInput() {
		
		if(Game.getKeyManager().space) {
			
			timestamp = System.nanoTime();
			temp = true;
			try {
				AudioMain.playL("src/audio/Start.wav");
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (AWTException e) {
				e.printStackTrace();
			}
			
		}
		
		timestamp2 = System.nanoTime();
		
		
		
		if (temp == true) {
		if ((timestamp2-timestamp) > 1000000000) {
			Game.setState("Start");
			timestamp = 0;
			timestamp2 = 0;
			Opacity = 0;
		}
		}
		
		

	}

}
