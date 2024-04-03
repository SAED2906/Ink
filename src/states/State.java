package states;

import java.awt.Graphics;

import game.Game;


public class State {
	
	public static void render(Graphics g) {
		
		if (Game.getState().equalsIgnoreCase("menu")) {
		
			MenuState.render(g);
		}
		if (Game.getState().equalsIgnoreCase("start")) {
			
			StartState.render(g);
		}
		if (Game.getState().equalsIgnoreCase("Scene1")) {
			Scene1.render(g);
		}
		
	}
	
	public static void tick() {
		
		if (Game.getState().equalsIgnoreCase("menu")) {
			MenuState.tick();
		}
		if (Game.getState().equalsIgnoreCase("start")) {
			StartState.tick();
		}

		if (Game.getState().equalsIgnoreCase("Scene1")) {
			Scene1.tick();
		}
		
	}
	
	
	
	

}
