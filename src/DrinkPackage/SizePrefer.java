/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrinkPackage;

/**
 *Name: Stanley Tantysco
 * Binusian ID: 2201814670
 * Coffee/Tea Shop JFrame Application
 */
//Size Prefer abstract class
public abstract class SizePrefer {
    //Declare protected attributes
    protected String size;
    protected double sizeup;
    
    public abstract void setSize(String s);//abstract size setter method
    public abstract void setSizeup(double p);//abstract size up price setter method
    
    // size getter method
    public String getSize(){
        return size;
    }
    // size up price getter method
    public double getSizeUp(){
        return sizeup;
    }
}
//end of Size Prefer abstract class