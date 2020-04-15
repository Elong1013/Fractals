
package com.eonsahead.fractals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;
/**
 * Creates a panel and draws some bacic components of the 
 * Mandelbrot Set on window.
 * 
 * @author Erlang Long 
 * @version 14 April 2020
*/

public class SimpleBitmap extends JPanel {
    
    //JPanel Variables
    private static final int BITMAP_WIDTH = 512;
    private static final int BITMAP_HEIGHT = 512;
    private BufferedImage image;
    
    /**
     * Creates an instance of this class.
     */
    public SimpleBitmap() {
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        this.setBackground(Color.GRAY);
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    }// SimpleBitmap()
    
    /**
     * Mandelbrot Set image by assigning each pixel a color
     * to the graph ofMandelbrot Set.
     * 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        
        int w = this.getWidth();
        int h = this.getHeight();
        
        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double) w) / BITMAP_WIDTH, 
                        ((double) h) / BITMAP_HEIGHT);
        
        WritableRaster raster = this.image.getRaster();
        
                int [][] palette = new int[64][3];
        
        Color startColor = Color.RED;
        int r0 = startColor.getRed();
        int g0 = startColor.getGreen();
        int b0 = startColor.getBlue();
        
        Color endColor = Color.BLUE;
        int r1 = endColor.getRed();
        int g1 = endColor.getGreen();
        int b1 = endColor.getBlue();
        
        for( int i = 0; i < 64; i++ ) {
//            double fraction = ((double) i) / 63;
//            int red = (int) ((1 - fraction) * r0 + fraction * r1);
//            int green = (int) ((1 - fraction) * g0 + fraction * g1);
//            int blue = (int) ((1 - fraction) * b0 + fraction * b1);
            
            palette[i][0] = (int) (256 * Math.random()); //red;
            palette[i][1] = (int) (256 * Math.random()); //green;
            palette[i][2] = (int) (256 * Math.random()); //blue;            
        } // for
        
        double xMin = 0; 
        double xMax = 511;
        double yMin = 0 ;
        double yMax = 511;
        
        double uMin =  0.2;
        double uMax =  0.81;
        double vMin =  0.2;
        double vMax =  0.63;
        
        int []blue = {0,0,255};
        int []yellow = {222,222,0};
        
        /**
         * The mapping is a translation, followed by a scaling
         * (or two, depending upon the method of counting), 
         * followed by another translation. Moreover, z is to make sure we
         * are in the iteration loop
         */
        for(int row = 0; row < BITMAP_HEIGHT; row++) {
            double y = row;
            for (int column = 0; column < BITMAP_WIDTH; column++){
                double x = column; 
                
                double u = uMin + (uMax - uMin ) * (x- xMin)/(xMax - xMin);
                double v = vMin + (vMax - vMin ) * (y- yMin)/(yMax - yMin);
                
                Complex z = new Complex (0.0 , 0.0);
                Complex c = new Complex (u,v);
                
                int count = 0;
                
                while (z.magnitude() < 4.0 && count < 64){
                    z = z.multiplication(z);
                    z = z.addition(c);
                    count++;
                    
                }//while 
                if (count == 64){
                    raster.setPixel(row, column, yellow);
                }//if 
                else{
                    raster.setPixel (row,column,palette[count]);
                }
            }
                    
        }
        
        
       
//        for(int row = 0; row < BITMAP_HEIGHT; row++) {
//            for(int column = 0; column < BITMAP_WIDTH; column++) {
//                if (row < column){
//                    raster.setPixel (row,column,yellow);
//                }else{
//                    raster.setPixel (row,column,black);
//                }
//            }// for
//        }// for
        
        g2D.drawImage(image, scale, this);
    }// paintComponent(Graphics)
    
    
}// SimpleBitmap
