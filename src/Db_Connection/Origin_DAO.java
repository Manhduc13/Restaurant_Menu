/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Db_Connection;

import Model.Origin;
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
public class Origin_DAO {
    public List<Origin> getOriginOfDish(int dishID) throws SQLException{
        List<Origin> origins = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM origins WHERE originID IN "
                        + "(SELECT originID FROM dish_origin WHERE dishID = ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, dishID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Origin origin = new Origin();
                origin.setId(rs.getInt("originID"));
                origin.setName(rs.getString("originName"));
                
                origins.add(origin);
            }
        } catch (SQLException e) {}
        return origins;
    }
    
    public List<Origin> getOriginOfCategory(int categoryID) throws SQLException{
        List<Origin> origins = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM origins WHERE originID IN"
                        + "(SELECT originID FROM dish_origin WHERE dishID IN"
                        + "(SELECT dishID FROM dish_category WHERE categoryID = ?))";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, categoryID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Origin origin = new Origin();
                origin.setId(rs.getInt("originID"));
                origin.setName(rs.getString("originName"));
                
                origins.add(origin);
            }
        } catch (SQLException e) {}
        return origins;
    }
    
    public List<Origin> getAllOrigin() throws SQLException{
        List<Origin> origins = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * FROM origins";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Origin origin = new Origin();
                origin.setId(rs.getInt("originID"));
                origin.setName(rs.getString("originName"));
                
                origins.add(origin);
            }
        } catch (SQLException e) {}
        return origins;
    }
}
