/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eonsahead.fractals;
/**
 *Creates a window used to draw the Mandelbrot Set.
 * @author Erlang Long
 */
import java.awt.Container;
import javax.swing.JFrame;


public class simple extends JFrame {
private static final int SIMPLE_WIDTH = 512;
private static final int SIMPLE_HEIGHT = 512;
private static final String SIMPLE_TITLE = "Simple";
    
    /**
     * insert a class for creating a window with some basic using bottoms
     */
    public simple() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIMPLE_WIDTH, SIMPLE_HEIGHT);
        this.setTitle(SIMPLE_TITLE);
        
        Container pane = this.getContentPane();
        
       
        SimpleBitmap panel = new SimpleBitmap();
        pane.add(panel);
        
        this.setVisible(true);
    }// Simple()
    
    /**
     * use for execution
     * @param args 
     */
    public static void main(String[] args) {
        simple simple = new simple();
    }// main(String[])
    
}
