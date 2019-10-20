package com.vasilevskiy.gamesample;

import java.awt.*;
import java.util.Random;

public class Food extends Sqare {
    private int size;
    private int roundbs(int s){
        int ret = s%size;
        if(ret == 0){
            return s;
        }
        else {
            if(ret>size/2)
                return s-ret+size;
            else
                return s-ret;
        }
    }
    public void setRandomPos(int mx, int my){
        int ty = new Random().ints(0,my-size*2).findFirst().getAsInt();
        int tx = new Random().ints(0,mx-size*2).findFirst().getAsInt();
        this.setStartY(roundbs(ty));
        this.setStartX(roundbs(tx));
    }

    public Food(int sx, int sy, Color c, int size) {
        super(sx, sy, c, size);
        this.size = size;
    }
}
