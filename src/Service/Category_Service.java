/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Db_Connection.Category_DAO;
import Model.Category;
import java.util.List;

/**
 *
 * @author manh computer
 */
public class Category_Service {
    private Category_DAO categoryDAO = new Category_DAO();
    
     public List<Category> getCategoryOfDish(int dishID){
         return categoryDAO.getCategoryOfDish(dishID);
     }
}
