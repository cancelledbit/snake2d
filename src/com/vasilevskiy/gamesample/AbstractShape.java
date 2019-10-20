package com.vasilevskiy.gamesample;

import java.awt.*;

public abstract class AbstractShape implements IShape {
    private int startx;
    private int starty;
    private Color color;
    public AbstractShape(int sx,int sy, Color c){
        this.setColor(c);
        this.setStartX(sx);
        this.setStartY(sy);
    }
    @Override
    public int getStartX() {
        return startx;
    }

    @Override
    public int getStartY() {
        return starty;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setStartX(int x) {
        this.startx = x;
    }

    @Override
    public void setStartY(int y) {
        this.starty = y;
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }
}
