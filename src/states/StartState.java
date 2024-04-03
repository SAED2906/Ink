package states;

import java.awt.Color;
import java.awt.Graphics;

import game.Game;
import gfx.Assets;


public class StartState {
	
	static int counter = 0;
	static int x = 0;
	static boolean isJump = false;
	static boolean falling = true;
	
	private static float gravity = 0.5f;
	
	static boolean inbounds = true;
	
	///player
	
	static float velX = 0;
	static float velY = 0;
	
	
	static int xLoc = 500;
	static int yLoc = 500;
	
	
	///
	
public static void render(Graphics g) {
	
	g.setColor(Color.black);
	g.fillRect(0, 980, 1920, 100);
	
	
	
		
		//g.fillRect(xLoc, yLoc, 100, 100);
		g.drawImage(Assets.man, xLoc, yLoc, 100, 100, null);
		
		
		

	
	}	

	public static void tick() {
		
		//Camera.tick();
		xLoc += velX;
		//yLoc += velY;
		inBounds();
		getInput();
		
		
		if (falling && inBounds()) {
			yLoc += velY;
			//System.out.println(inBounds());
			velY += gravity;
		}
	}
	
	
	
	
	
	private static void getInput() {
		
		if(Game.getKeyManager().space) {
			yLoc = yLoc - 10;
			falling = true;
			
			velY = 0;
		}
		
		if(Game.getKeyManager().right) {
			xLoc= xLoc + 10;
		}
		if(Game.getKeyManager().left) {
			xLoc= xLoc - 10;
		}

	}
	
	
	
	
	
	public static boolean inBounds() {
		
		System.out.println(inbounds);
		if (yLoc > 880) {
			inbounds = false;
			yLoc = 880;
		}
		
		if (yLoc < 880) {
			inbounds = true;
		}
		
		
		return inbounds;
	}
	
	

}
