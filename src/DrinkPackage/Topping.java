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
//Topping interface
public interface Topping {
    
    public void addTopping(String t);//topping setter method
    public void addTopping(String t,double p);//overloading topping setter method
    public String getTopping();//topping name getter method
    public double getTopPrice();//topping price getter method
    
}
