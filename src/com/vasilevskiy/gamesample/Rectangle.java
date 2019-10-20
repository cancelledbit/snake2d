package com.vasilevskiy.gamesample;

import java.awt.*;

public class Rectangle extends AbstractShape {
    private int sizex;
    private int sizey;
    public Rectangle(int sx, int sy, Color c, int sizex, int sizey) {
        super(sx, sy, c);
        this.setSizeX(sizex);
        this.setSizeY(sizey);
    }

    public int getSizeX() {
        return sizex;
    }

    public void setSizeX(int sizex) {
        this.sizex = sizex;
    }

    public int getSizeY() {
        return sizey;
    }

    public void setSizeY(int sizey) {
        this.sizey = sizey;
    }
}
