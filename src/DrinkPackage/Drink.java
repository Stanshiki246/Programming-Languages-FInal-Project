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
//Drink class
public class Drink extends SizePrefer{
    //declare private attributes
    private String name;
    private double price;
    private String drinktype;
    
    //Default Constructor
    public Drink() {
        this.name="";
        this.price=0.0;
        this.drinktype="";
        super.sizeup=0.0;
    }
    
    //Overloading Constructor
    public Drink(String name, double price,String drinktype,double sizeup) {
        this.name = name;
        this.price = price;
        this.drinktype=drinktype;
        super.sizeup=sizeup;
    }

   //name getter method
    public String getName() {
        return name;
    }
    
    //drink type getter method
    public String getDrinktype() {
        return drinktype;
    }

    //drink type setter method
    public void setDrinktype(String drinktype) {
        this.drinktype = drinktype;
    }

    //price getter method
    public double getPrice() {
        return price;
    }

    //name setter method
    public void setName(String name) {
        this.name = name;
    }

    //price setter method
    public void setPrice(double price) {
        this.price = price;
    }

    //Implementing size setter method 
    @Override
    public void setSize(String s) {
        super.size=s; 
    }

    //Implementing size up price setter method
    @Override
    public void setSizeup(double p) {
       super.sizeup=p; 
    }
}
//end of Drink class
