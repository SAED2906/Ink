package game;

import static reporting.logger.*;

public class start {
    public static final int DEFAULT_WIDTH = 1920;
    public static final int DEFAULT_HEIGHT = 1080;

    public static int width;
    public static int height;

    public static void main(String[] args) {
        if (args.length == 2) {
            try{
                width = Integer.parseInt(args[0]);
            } catch (Exception e) {
                err("Invalid width supplied, using default: " + DEFAULT_WIDTH);
                width = DEFAULT_WIDTH;
            }
            try {
                height = Integer.parseInt(args[1]);
            } catch (Exception e) {
                err("Invalid height supplied, using default: " + DEFAULT_HEIGHT);
                height = DEFAULT_HEIGHT;
            }
        } else {
            width = DEFAULT_WIDTH;
            height = DEFAULT_HEIGHT;
        }

        inf("Window starting dimentions: " + width + "x" + height);

        Game game = new Game("Untitled", width, height);
		game.start();

        
    }
}