/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Db_Connection.Ingredient_DAO;
import Model.Ingredient;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author manh computer
 */
public class Ingredient_Service {
    private Ingredient_DAO ingredientDAO = new Ingredient_DAO();
    
    public List<Ingredient> getIngredientOfDish(int dishId) throws SQLException{
        return ingredientDAO.getIngredientOfDish(dishId);
    }
    public Ingredient getIngredientDetail(int id) throws SQLException{
        return ingredientDAO.getIngredientDetail(id);
    }
}
