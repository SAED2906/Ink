package gfx;

import java.awt.image.BufferedImage;

public class object {

    public BufferedImage texture;
    public int width;
    public int height;

    public int x;
    public int y;

    public String name;

    public object(BufferedImage texture, int width, int height, int x, int y, String name){
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.name = name;
    }
    
}
