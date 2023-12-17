/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Db_Connection;

import Model.Ingredient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manh computer
 */
public class Ingredient_DAO {
    public List<Ingredient> getIngredientOfDish(int dishID) throws SQLException{
        List<Ingredient> ingredients = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM ingredients WHERE ingredientID IN "
                        + "(SELECT ingredientID FROM dish_ingredient WHERE dishID = ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, dishID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Ingredient ingredient = new Ingredient();
                
                ingredient.setId(rs.getInt("ingredientID"));
                ingredient.setName(rs.getString("ingredientName"));
                ingredient.setQuantity(rs.getDouble("quantity"));
                ingredient.setExpiredDate(rs.getDate("expiredDate"));
                ingredient.setImportDate(rs.getDate("importDate"));
                ingredient.setUnit(rs.getString("unit"));
                
                ingredients.add(ingredient);
            }
        } catch (SQLException e) {}
        return ingredients;
    }
    
    public Ingredient getIngredientDetail(int ingredientID) throws SQLException{
        Ingredient ingredient = new Ingredient();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM ingredients WHERE ingredientID = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, ingredientID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                ingredient.setId(rs.getInt("ingredientID"));
                ingredient.setName(rs.getString("ingredientName"));
                ingredient.setQuantity(rs.getDouble("quantity"));
                ingredient.setExpiredDate(rs.getDate("expiredDate"));
                ingredient.setImportDate(rs.getDate("importDate"));
                ingredient.setUnit(rs.getString("unit"));
            }
        } catch (SQLException e) {}
        return ingredient;
    }
}
