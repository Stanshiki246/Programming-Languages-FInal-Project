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
//ColdDrink class
public class ColdDrink extends Drink implements SugarPrefer,ColdPrefer,Topping,Quantity{
    //declare private attributes
    private double sugar = 0.0;
    private String ice ="";
    private String toppingname="none";
    private double topprice=0.0;
    private int quantity =1;
    
    //Constructor
    public ColdDrink(String name, double  price){
        super(name, price,"Cold",10000.0);
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

    //Implementing ice setter method
    @Override
    public void setice(String i) {
        this.ice = i; 
    }

    //Implementing ice getter method
    @Override
    public String getice() {
       return ice; 
    }

    //Implementing topping setter method
    @Override
    public void addTopping(String t) {
        this.toppingname=t; 
        this.topprice=0.0;
    }

    //Implementing overloading topping setter method
    @Override
    public void addTopping(String t, double p) {
       this.toppingname=t; 
       this.topprice=p;
    }

    //Implementing topping name getter method
    @Override
    public String getTopping() {
        return toppingname; 
    }

    //Implementing topping price getter method
    @Override
    public double getTopPrice() {
       return topprice; 
    }
    
    //total price getter method
    public double getTotal(){
        //to check whether size is regular or large
        if(super.getSize().equalsIgnoreCase("regular"))
        {
            return (super.getPrice() + this.topprice)*this.quantity;//get total price after excluding size up price
        }
        else if(super.getSize().equalsIgnoreCase("large"))
        {
            return (super.getPrice() + this.topprice + super.getSizeUp())*this.quantity;//get total price after including size up price
        }
        return 0;//error handling
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
//end of Cold Drink class