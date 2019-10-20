package com.vasilevskiy.gamesample;

public class Vector {
    private double x;
    private double y;
    public Vector(double wx, double wy){
        x = wx;
        y = wy;

    };

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void multiply(double c){
        this.setX(this.getX()*c);
        this.setY(this.getY()*c);
    }
    public void divide(double c) throws Exception {
        if(c == 0 ){
            throw new Exception("Cant divide by zero");
        }
        this.setX(this.getX()/c);
        this.setY(this.getY()/c);
    }
}
