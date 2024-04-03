package gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	public static BufferedImage grass, dirt, player, stone, bg1, bg2, bg3, TC, T, man;
	
	public static void init() {
		
		//SpriteSheet sheet = new SpriteSheet(imageLoader.loadImage("D:\\Backup\\Eclipse\\eclipse-workspace\\Game3\\res\\textures\\SpriteSheet.png"));
		SpriteSheet sheet2 = new SpriteSheet(imageLoader.loadImage("src/GameTexture/Mountain1T.png"));
		SpriteSheet sheet3 = new SpriteSheet(imageLoader.loadImage("src/GameTexture/Mountain2T.png"));
		SpriteSheet sheet4 = new SpriteSheet(imageLoader.loadImage("src/GameTexture/Mountain3T.png"));
		SpriteSheet sheet5 = new SpriteSheet(imageLoader.loadImage("src/GameTexture/Start1.png"));
		SpriteSheet sheet6 = new SpriteSheet(imageLoader.loadImage("src/GameTexture/T.png"));
		SpriteSheet sheet7 = new SpriteSheet(imageLoader.loadImage("src/GameTexture/Man2.png"));
		
		//player = sheet.crop(64, 0, width, height);
		//grass = sheet.crop(0, 0, width, height);
		//dirt = sheet.crop(32, 0, width, height);
		//stone = sheet.crop(96, 0, width, height);
		bg1 = sheet2.crop(0, 0, 1920, 1080);
		bg2 = sheet3.crop(0, 0, 1920, 1080);
		bg3 = sheet4.crop(0, 0, 1920, 1080);
		TC = sheet5.crop(0, 0, 1920, 1080);
		T = sheet6.crop(0, 0, 1920, 1080);
		man = sheet7.crop(0, 0, 100, 100);
		
		
	}

}
