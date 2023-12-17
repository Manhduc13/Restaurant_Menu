package Db_Connection;

import Model.Dish;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dish_DAO {
    
    public List<Dish> getDishesByCategory(int categoryID) throws SQLException{
        List<Dish> dishes = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM dishes WHERE dishID IN"
                        + "(SELECT dishID FROM dish_category WHERE categoryID = ?) AND available = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, categoryID);
            preparedStatement.setBoolean(2, true);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Dish dish = new Dish();
                dish.setId(rs.getInt("dishID"));
                dish.setName(rs.getString("dishName"));
                dish.setPrice(rs.getDouble("price"));
                
                dishes.add(dish);
            }
        } catch (SQLException e) {}
        return dishes;
    }
    
    public Dish getDishDetail(int dishID) throws SQLException{
        Dish dish = new Dish();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * from dishes WHERE dishID = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, dishID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                dish.setId(rs.getInt("dishID"));
                dish.setName(rs.getString("dishName"));
                dish.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {}
        return dish;
    }
    
    public List<Dish> getDishByOriginOfCategory(int originID, int categoryID) throws SQLException{
        List<Dish> dishes = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM dishes WHERE dishID IN"
                        + "(SELECT dish_origin.dishID FROM dish_origin, dish_category WHERE dish_origin.dishID = dish_category.dishID AND dish_origin.originID = ? AND dish_category.categoryID = ?)"
                        + "AND available = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, originID);
            preparedStatement.setInt(2, categoryID);
            preparedStatement.setBoolean(3, true);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Dish dish = new Dish();
                dish.setId(rs.getInt("dishID"));
                dish.setName(rs.getString("dishName"));
                dish.setPrice(rs.getDouble("price"));
                
                dishes.add(dish);
            }
        } catch (SQLException e) {}
        return dishes;
    }
    
    public List<Dish> getDishByOrigin(int originID) throws SQLException{
        List<Dish> dishes = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM dishes WHERE dishID IN"
                        + "(SELECT dishID FROM dish_origin WHERE originID = ?)"
                        + "AND available = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, originID);
            preparedStatement.setBoolean(2, true);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Dish dish = new Dish();
                dish.setId(rs.getInt("dishID"));
                dish.setName(rs.getString("dishName"));
                dish.setPrice(rs.getDouble("price"));
                
                dishes.add(dish);
            }
        } catch (SQLException e) {}
        return dishes;
    }
    
    public List<Dish> getAllDish() throws SQLException{
        List<Dish> dishes = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM dishes WHERE available = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Dish dish = new Dish();
                dish.setId(rs.getInt("dishID"));
                dish.setName(rs.getString("dishName"));
                dish.setPrice(rs.getDouble("price"));
                
                dishes.add(dish);
            }
        } catch (SQLException e) {}
        return dishes;
    }
}
