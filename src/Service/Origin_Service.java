/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Db_Connection.Origin_DAO;
import Model.Origin;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author manh computer
 */
public class Origin_Service {
    private Origin_DAO originDAO = new Origin_DAO();
    
    public List<Origin> getOriginOfDish(int dishId) throws SQLException{
        return originDAO.getOriginOfDish(dishId);
    }
    
    public List<Origin> getOriginOfCategory(int categoryID) throws SQLException{
        return originDAO.getOriginOfCategory(categoryID);
    }
    
     public List<Origin> getAllOrigin() throws SQLException{
         return originDAO.getAllOrigin();
     }
}
      