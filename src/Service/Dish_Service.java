package Service;

import Db_Connection.Dish_DAO;
import Model.Dish;
import java.sql.SQLException;
import java.util.List;

public class Dish_Service {
     private Dish_DAO dishDAO = new Dish_DAO();
    
     public List<Dish> getDishesByCategory(int categoryID) throws SQLException{
         return dishDAO.getDishesByCategory(categoryID);
     }
     public Dish getDishDetail(int dishID) throws SQLException{
         return dishDAO.getDishDetail(dishID);
     }
     public List<Dish> getDishByOriginOfCategory(int originID, int categoryID) throws SQLException{
         return dishDAO.getDishByOriginOfCategory(originID, categoryID);
     }
     public List<Dish> getDishByOrigin(int originID) throws SQLException{
         return dishDAO.getDishByOrigin(originID);
     }
     public List<Dish> getAllDish() throws SQLException{
         return dishDAO.getAllDish();
     }
}
