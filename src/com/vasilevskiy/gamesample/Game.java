package com.vasilevskiy.gamesample;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game implements Runnable, KeyListener {
    public static final int WIDTH = 800, HEIGHT = 600;
    private Thread thread;
    private boolean running = false;
    private boolean increaseReady = false;
    private int counter = 100;
    private Window window;
    private BufferStrategy bs;
    private Graphics g;
    private Snake snake;
    private Food food;
    public Game(){
        window = new Window(WIDTH,HEIGHT,"game",this);
        //window.addKeyListener(this);
        snake = new Snake(100,100,4,20,Color.cyan);
        food = new Food(220,200,Color.red,20);
    }
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (Exception e){
            e.getStackTrace();
        }

    }

    public static void main(String[] args) {
        Game g = new Game();
        g.start();
    }
    public void tick(){
        snake.move();
        if(snake.getShape().get(0).getStartX()==food.getStartX() && snake.getShape().get(0).getStartY()==food.getStartY()){
            food.setRandomPos(WIDTH,HEIGHT);
            snake.increase();
            this.increaseReady = true;
        }
        System.out.println(snake.toString());
        if(snake.getHead().getStartY()>=HEIGHT && snake.getVector().getY()==1)
            snake.getHead().setStartY(0);
        if(snake.getHead().getStartY()+snake.getBlocksize()<=0 && snake.getVector().getY()==-1)
            snake.getHead().setStartY(HEIGHT-snake.getBlocksize()*2);
        if(snake.getHead().getStartX()>=WIDTH && snake.getVector().getX()==1)
            snake.getHead().setStartX(0);
        if(snake.getHead().getStartX()+snake.getBlocksize()<=0 && snake.getVector().getX()==-1)
            snake.getHead().setStartX(WIDTH-snake.getBlocksize());
        for(int i=1;i<snake.getLength();i++){
            if (snake.getHead().getStartX() == snake.getShape().get(i).getStartX()
            && snake.getHead().getStartY() == snake.getShape().get(i).getStartY()){
                running = false;
                render();
            }
        }
    }
    public void render(){
        Toolkit.getDefaultToolkit().sync();
        bs = window.getCanvas().getBufferStrategy();
        if(bs==null){
            window.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0, WIDTH, HEIGHT);
        if (!running) {
            g.setFont(new Font("Arial",Font.BOLD,36));
            g.drawString(String.format("Game Over! Total score: %d",snake.getLength()),20,200);
            bs.show();
            g.dispose();
        }
        g.drawString(Integer.toString(snake.getLength()),10,10);
        for (Sqare s : snake.getShape()){
            g.setColor(snake.getColor());
            g.fillRect(s.getStartX(),s.getStartY(),s.getSizeX(),s.getSizeY());
        }
        g.setColor(food.getColor());
        g.fillRect(food.getStartX(),food.getStartY(),food.getSizeX(),food.getSizeY());
        bs.show();
        g.dispose();

    }
    @Override
    public void run() {
        long lastTime = System.nanoTime(); // get current time to the nanosecond
        double amountOfTicks = 5.0; // set the number of ticks
        double ns = 1000000000 / amountOfTicks; // this determines how many times we can devide 60 into 1e9 of nano seconds or about 1 second
        double delta = 0; // change in time (delta always means a change like delta v is change in velocity)
        long timer = System.currentTimeMillis(); // get current time
        int frames = 0; // set frame variable
        while(running){
            if(increaseReady && snake.getLength()%5==0){
                amountOfTicks+=2;
                increaseReady = false;
            }
            ns = 1000000000 / amountOfTicks;
            long now = System.nanoTime(); // get current time in nonoseconds durring current loop
            delta += (now - lastTime) / ns; // add the amount of change since the last loop
            lastTime = now;  // set lastTime to now to prepare for next loop
            //if (delta>1)
                //System.out.println(delta);
            while(delta >= 1){
                tick();
                delta--;  // lower our delta back to 0 to start our next frame wait
            }
            if(running){
                render(); // render the visuals of the game
            }
            frames++; // note that a frame has passed
        }
        stop(); // no longer running stop the thread
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 39:snake.setVector(new Vector(1,0));break;
            case 40:snake.setVector(new Vector(0,1));break;
            case 38:snake.setVector(new Vector(0,-1));break;
            case 37:snake.setVector(new Vector(-1,0));break;
            default:break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
