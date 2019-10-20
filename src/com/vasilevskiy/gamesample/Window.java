package com.vasilevskiy.gamesample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Window extends Canvas {
    private Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public Window(int width, int height, String title, KeyListener keyListener){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.addKeyListener(keyListener);
        canvas.setFocusable(true);
        frame.add(canvas);
        frame.pack();

        //g.start();
    }
}
