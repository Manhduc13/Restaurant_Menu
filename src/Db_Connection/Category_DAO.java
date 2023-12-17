package Db_Connection;

import Model.Category;
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
public class Category_DAO {
    public List<Category> getCategoryOfDish(int dishID){
        List<Category> categories = new ArrayList<>();
        Connection con = JDBC_Connection.getJDBCConnection();
        String sql = "SELECT * from categories WHERE categoryID IN"
                        + "(SELECT categoryID FROM dish_category WHERE dishID = ?)";
        
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, dishID);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("categoryID"));
                category.setName(rs.getString("categoryName"));
                
                categories.add(category);
            }
        } catch (SQLException e) {}
        return categories;
    }
}
