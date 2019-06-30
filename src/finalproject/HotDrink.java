/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import DrinkPackage.*;
/**
 *Name: Stanley Tantysco
 * Binusian ID: 2201814670
 * Coffee/Tea Shop JFrame Application
 */
//Hot Drink class
public class HotDrink extends Drink implements SugarPrefer,Quantity{
    //declare private attributes
    private double sugar=0.0;
    private int quantity =1;
    
    //Constructor
    public HotDrink(String name, double price){
        super(name,price,"Hot",5000.0);
    }

    //Implementing sugar setter method
    @Override
    public void setsugar(double i) {
        this.sugar=i; 
    }

    //Implementing sugar getter method
    @Override
    public double getsugar() {
       return sugar; 
    }
    
    //total price getter method
    public double getTotal(){
        //to check whether size is regular or large
        if(super.getSize().equalsIgnoreCase("regular")){
            return super.getPrice()*this.quantity;//get total price after excluding size up price
        }
        else if(super.getSize().equalsIgnoreCase("large")){
            return (super.getPrice() + super.getSizeUp())*this.quantity;//get total price after including price
        }
        return 0;
    }

    //Implementing quantity setter method
    @Override
    public void setquantity(int q) {
        this.quantity=q; 
    }

    //Implementing quantity getter method
    @Override
    public int getquantity() {
        return quantity; 
    }
}
//end of Hot Drink class
