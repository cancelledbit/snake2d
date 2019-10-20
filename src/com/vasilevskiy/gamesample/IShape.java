package com.vasilevskiy.gamesample;

import java.awt.*;

public interface IShape {
    int getStartX();
    int getStartY();
    Color getColor();
    void setStartX(int x);
    void setStartY(int y);
    void setColor(Color c);
}
