/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eonsahead.fractals;

/**
 *
 * @author Erlang Long
 */

public class Complex {
    /**
     * from what I learned in math class, a complex number is constructed by
     * real number part and the imagenary part,which is multiplied with i.
     * 
     * <p>
     * I will call real number as "RN".
     * I will call imagenary number as "IN".
     */

    private final double RN;
    private final double IN;
    
    
    /**
     * Creates a complex number by storing RN and In in two different 
     * variable
     * @param x The real part of the complex number
     * @param y the real number of imaginary part of the complex number 
     */
    public Complex(double x, double y) {
        this.RN = x;
        this.IN = y;
    }// Complex(double, double)
    
    
    
    /**
     * Adds this complex number with original one.
     * 
     * @param c Another complex number.
     * @return the sum of this complex number and another complex number.
     */
    public Complex addition(Complex c) {
        double X = this.RN + c.RN;
        double Y = this.IN + c.IN;
        
        return new Complex(X, Y);
    }// add(Complex)
    
    
    /**
     * Subtracts another complex number from this original one.
     * 
     * @param c Another complex number.
     * @return  the difference between original one and another complex number.
     */
    public Complex subtraction(Complex c) {
        double newX = this.RN - c.RN;
        double newY = this.IN - c.IN;
        
        return new Complex(newX, newY);
    }// subtract(Complex)
    
    
    /**
     * Multiplies this complex number with another complex number.
     * 
     * @param c Another complex number.
     * @return A complex number that is the product of the 
     * original one and another complex number.
     */
    public Complex multiplication(Complex c) {
        double newX = (this.RN * c.RN)  - (this.IN * c.IN);
        
        double newY = (this.RN * c.IN)  + (c.RN * this.IN);
        
        return new Complex(newX, newY);
    }// multiply(Complex)
    
    
    /**
     * Divides this complex number by another complex number.
     * 
     * @param c Another complex number.
     * @return A complex number that is the quotient of the
     * this complex number divided by another complex number.
     */
    public Complex division(Complex c) {
        double XNumerator = (this.RN * c.RN) + (this.IN * c.IN);
        
        double YNumerator = (this.IN * c.RN) - (this.RN * c.IN);
        
        double Denominator = this.RN * this.RN + this.IN *this.IN;
        
        double X = XNumerator / Denominator;
        double Y = YNumerator / Denominator;
        
        return new Complex(X, Y);
    }// divide(Complex)
    
    
    /**.
     * The magnitude of a complex number is the distance from the origin in
     * the complex plane. 
     * we could use (a*a + b*b)^1/2=c
     * @return The magnitude of this complex number.
     */
    public double magnitude() {
        double xSquare = this.RN * this.RN;
        double ySquare = this.IN *this.IN;
        
        return Math.sqrt(xSquare + ySquare);
    }// magnitude()

    
    /**
     * Gets the real part of this complex number.
     * 
     * The real part of this complex number is the value of x 
     * @return The real component of this complex number. 
     */
    public double getReal() {
        return this.RN;
    }// getReal()

    
    
    /**
     * Gets the imaginary component of this complex number.
     * 
     * The real number of imaginary part of this complex number is the value of y  
     * @return The imaginary component of this complex number. 
     */
    public double getImaginary() {
        return this.IN;
    }// getImaginary()
    
    /**
     * Returns a string that represents this complex number.
     * @return A string representation of this complex number.
     */
    @Override        
    public String toString() {
        return this.RN + " + i * " + this.IN;
    }// toString()
    
}// Complex
