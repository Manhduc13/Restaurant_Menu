/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;

/**
 *
 * @author manh computer
 */
public class Dish {
    private int Id;
    private String name;
    private double price;
    private boolean isAvailable;
   
    public void setId(int Id){
        this.Id = Id;
    }
    public int getId(){
        return this.Id;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
    
    public void setIsAvailable(boolean available){
        this.isAvailable = available;
    }
    public boolean getIsAvailable(){
        return this.isAvailable;
    }
}
