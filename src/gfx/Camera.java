package gfx;

import game.Game;

public class Camera {
	
	static int x = 0;
	static int y = -40;
	static int xMove = 0;
	static int yMove = 0;
	
	
	public static void tick() {
		
		getInput();
		x = xMove;
		y = yMove;
		
		
		//Temp Camera Control
		
		//xMove = 0;
		//yMove = 0;
		
	}
	
	private static void getInput() {
		
		if(Game.getKeyManager().up)
			yMove = -1;
		//System.out.print("yes");
	
		if(Game.getKeyManager().down)
			yMove = 1;
		
		if(Game.getKeyManager().left)
			xMove = -1;
	
		if(Game.getKeyManager().right)
			xMove = 1;
	}
	
	public static int getx() {
		
		//System.out.print(x);
		return x;
		
	}
	
	/*public static void setX(int Xint) {
		x = Xint;
	}*/


}
