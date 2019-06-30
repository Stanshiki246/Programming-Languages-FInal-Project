/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;
import java.util.*;
/**
 *Name: Stanley Tantysco
 * Binusian ID: 2201814670
 * Coffee/Tea Shop JFrame Application
 */
//Order Queue class
public class OrderQueue {
    //declare private attributes
    private Queue<Integer> q= new LinkedList();//create new Queue list
    private int number = 1;//default variable
    
    //push method
    public void push(int n){
        q.add(n);//push number into queue list
    }
    
    //pop method
    public void pop(){
        q.remove();//pop number from queue list
    }
    
    //top method
    public int top(){
        return q.peek();//show front of queue list
    }

    //number getter method
    public int getNumber() {
        return number;
    }
    
    //number increment method
    public void numberincrement(){
        this.number +=1;//increment number
    }
    
    //empty queue checking method
    public boolean isEmptyQueue(){
        return q.isEmpty();//get  empty queue list flag
    }
}
//end of Order Queue class