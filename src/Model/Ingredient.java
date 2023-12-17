/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author manh computer
 */
public class Ingredient {
    private int Id;
    private String name;
    private double quantity;
    private String unit;
    private Date importDate;
    private Date expiredDate;
    
    public void setId(int Id){
        this.Id  = Id;
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
    public void setQuantity(double quantity){
        this.quantity = quantity;
    }
    public double getQuantity(){
        return this.quantity;
    }
    public void setUnit(String unit){
        this.unit = unit;
    }
    public String getUnit(){
        return this.unit;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }
    
}
