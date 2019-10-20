package com.vasilevskiy.gamesample;

import java.awt.*;
import java.util.ArrayList;

public class Snake extends AbstractShape {
    private Vector vector;
    private ArrayList<Sqare> snake;
    private Sqare head;
    private Sqare tail;
    private int length;
    private int blocksize;

    public Snake(int sx, int sy, int length, int blocksize, Color c) {
        super(sx, sy, c);
        this.blocksize = blocksize;
        this.length = length;
        this.snake = new ArrayList<>();
        this.vector = new Vector(1,0);
        for (int i = 0; i < length; i++) {
            sy = sy + blocksize;
            sx = sx;
            snake.add(i, new Sqare(sx, sy, c, blocksize));
        }
        //this.head = snake.get(0);


    }
    public void move(){
        int newx = (int)(snake.get(0).getStartX()+(blocksize*vector.getX()));
        int newy = (int)(snake.get(0).getStartY()+(blocksize*vector.getY()));
        Sqare sq = new Sqare(newx,newy,this.getColor(),this.blocksize);
        snake.add(0,sq);
        this.setStartX(sq.getStartX());
        this.setStartY(sq.getStartY());
        snake.remove(snake.size()-1);
    }

    public void setVector(Vector vector) {
        this.vector = vector;
    }

    public int getLength() {
        return length;
    }
    public Sqare getHead(){
        return snake.get(0);
    }
    public void increase(){
        int newx = (int)(snake.get(0).getStartX()+(blocksize*vector.getX()));
        int newy = (int)(snake.get(0).getStartY()+(blocksize*vector.getY()));
        Sqare sq = new Sqare(newx,newy,this.getColor(),this.blocksize);
        snake.add(0,sq);
        this.length++;
    }
    public ArrayList<Sqare> getShape() {
        return snake;
    }

    public Vector getVector() {
        return vector;
    }
    public int getBlocksize(){
        return blocksize;
    }
    @Override
    public String toString() {
        return String.format("posX: %d posY %d vectorX %f vectorY %f",this.getStartX(),
                this.getStartY(),
                this.getVector().getX(),
                this.getVector().getY());
    }
}
