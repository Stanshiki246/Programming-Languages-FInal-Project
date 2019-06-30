/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import DrinkPackage.*;
import java.util.ArrayList;
import java.io.*;
/**
 *Name: Stanley Tantysco
 * Binusian ID: 2201814670
 * Coffee/Tea Shop JFrame Application
 */
//Order List class
public class OrderList {
    //declare private attributes
    private ArrayList<Drink> ol = new ArrayList();//create new array list
    private Drink d;
    private HotDrink hd;
    private ColdDrink cd;
    private File file;
    private boolean paid = false;//default paid variable
    
    //paid getter method
    public boolean isPaid() {
        return paid;
    }

    //paid setter method
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    //add order method
    public void addOrder(Drink d){
        ol.add(d);//push drink object into order list
    }
    
    //delete order method
    public boolean deleteOrder(String n){
        boolean found = false;//declare flag attribute
        for(Drink d: ol){
            //to check whether key name is same as one of drink object's name in the list or not
            if(d.getName().equalsIgnoreCase(n)){
                ol.remove(d);//delete drink object
                found = true;//change the value of flag variable
                break;//stop looping
            }
        }
        return found;//get the flag value
    }
    
    // write file method
    public void write(String f) throws IOException{
        file = new File(f +".txt");//create new file
        FileWriter w = new FileWriter(file);//create new writer object
        String newline = System.getProperty("line.separator");//get line separator
        for(Drink d: ol){
            //to check whether drink object is cold drink or hot drink
            if(d instanceof ColdDrink){
                cd=(ColdDrink)d;//change into cold drink object
                //write each value of attributes in cold drink object into the file
                w.write(cd.getName()+";"+cd.getquantity()+";"+cd.getsugar() +";"+cd.getice()+";"+cd.getSize()+";"+cd.getTopping()+";"+cd.getTopPrice()+";"+cd.getPrice()+newline);
            }
            else if(d instanceof HotDrink){
                hd= (HotDrink)d;//change into hot drink object
                //write each value of attributes in hot drink into the file
                w.write(hd.getName()+";"+hd.getquantity()+";"+hd.getsugar()+";"+hd.getSize()+";"+hd.getPrice()+newline);
            }
        }
        w.close();//close the file
    }
    //overloading write file method
    public void write(String f,int n) throws IOException{
        file = new File("Customer"+f +".txt");//create new file
        FileWriter w = new FileWriter(file);//create new writer object
        String newline = System.getProperty("line.separator");//get line separator
        for(Drink d: ol){
            //to check whether drink object is cold drink or hot drink
            if(d instanceof ColdDrink){
                cd=(ColdDrink)d;//refer it to cold drink object
                 //write each value of attributes in cold drink object into the file
                w.write(cd.getName()+";"+cd.getquantity()+";"+cd.getsugar() +";"+cd.getice()+";"+cd.getSize()+";"+cd.getTopping()+";"+cd.getTopPrice()+";"+cd.getPrice()+newline);
            }
            else if(d instanceof HotDrink){
                hd= (HotDrink)d;//refer it to hot drink object
                //write each value of attributes in hot drink into the file
                w.write(hd.getName()+";"+hd.getquantity()+";"+hd.getsugar()+";"+hd.getSize()+";"+hd.getPrice()+newline);
            }
        }
        //to check whether order number is 0 or not
        if(n != 0){
            //write input n as order number into file
            w.write("Order Number:"+n+newline);
        }
        w.close();//close the file
    }
    //read file method
    public void read(String f) throws IOException{
        BufferedReader reader;//call BufferedReader
        file = new File(f+".txt");//get the file
        reader = new BufferedReader(new FileReader(file));//create new reader object
        String line = reader.readLine();//get line reading
        String [] parse;//declare array of string
        while(line != null){
            parse=line.split(";");//split string by ;
            //to check whether length of array is 8 or 5
            if(parse.length == 8){
                cd = new ColdDrink(parse[0],Double.valueOf(parse[7]));//create new Cold Drink object
                cd.setquantity(Integer.valueOf(parse[1]));//get quantity value
                cd.setsugar(Double.valueOf(parse[2]));//get sugar value
                cd.setice(parse[3]);//get ice value
                cd.setSize(parse[4]);//get size value
                cd.addTopping(parse[5],Double.valueOf(parse[6]));// get topping name and topping price values
                d=(Drink)cd;//refer it to Drink object
                ol.add(d);//add into order list
            }
            else if(parse.length==5){
                hd = new HotDrink(parse[0],Double.valueOf(parse[4]));//create new Hot Drink object
                hd.setquantity(Integer.valueOf(parse[1]));//get quantity value
                hd.setsugar(Double.valueOf(parse[2]));//get sugar value
                hd.setSize(parse[3]);//get size value
                d=(Drink)hd;//refer it to Drink object
                ol.add(d);//add into order list
            }
            line = reader.readLine();//go to next line
        }
        reader.close();//close the file
    }
   //list getter method
    public ArrayList getlist(){
        return ol;//get order list
    }
    //clear order list method
    public void clearOrder(){
        ol.clear();//make order list become empty
    }
    //empty order checking method
    public boolean isEmptyOrder(){
        return ol.isEmpty();//get value of empty order list flag
    }
}
//end of Order List class