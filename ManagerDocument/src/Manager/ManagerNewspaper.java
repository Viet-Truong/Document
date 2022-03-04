/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

/**
 *
 * @author AD
 */
import Document.ConnectDatabase;
import Document.Newspaper;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author AD
 */
public class ManagerNewspaper {
    public List<Newspaper> getAllNewspapers() throws SQLException {
        List<Newspaper> Newspapers = new ArrayList<Newspaper>();

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from newspaper";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Newspaper newspaper = new Newspaper();
                newspaper.setIdTL(rs.getInt("idTL"));
                newspaper.setNameNXB(rs.getString("nameNXB"));
                newspaper.setDate(rs.getString("dateNXB"));
                newspaper.setSoBanPhatHanh(rs.getInt("SoBanPhatHanh"));
                Newspapers.add(newspaper);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Newspapers;
    }
    
    public Newspaper getNewspaperById(int id) throws SQLException {

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from newspaper where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Newspaper newspaper = new Newspaper();
                newspaper.setIdTL(rs.getInt("idTL"));
                newspaper.setNameNXB(rs.getString("nameNXB"));
                newspaper.setDate(rs.getString("dateNXB"));
                newspaper.setSoBanPhatHanh(rs.getInt("SoBanPhatHanh"));
                
                return newspaper;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addNewspaper(Newspaper newspaper) throws SQLException {
        Connection connection =  ConnectDatabase.getConnectionDatabase();
        String sql="Insert into newspaper(idTL, nameNXB, dateNXB, soBanPhatHanh)"
                + "Values(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newspaper.getIdTL());
            preparedStatement.setString(2, newspaper.getNameNXB());
            preparedStatement.setString(3, newspaper.getDate());
            preparedStatement.setInt(4, newspaper.getSoBanPhatHanh());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateNewspaper(Newspaper newspaper) throws SQLException{
        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "Update newspaper set nameNXB = ? , dateNXB = ? , soBanPhatHanh = ? where idTL = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newspaper.getNameNXB());
            preparedStatement.setString(2, newspaper.getDate());
            preparedStatement.setInt(3, newspaper.getSoBanPhatHanh());
            preparedStatement.setInt(4, newspaper.getIdTL());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteNewspaper(int id) throws SQLException{
       Connection connection = ConnectDatabase.getConnectionDatabase();
       String sql = "delete from newspaper where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Newspaper findNewspaper(Newspaper newspaper) throws SQLException {
        List<Newspaper> listbook = new ArrayList<>();
        listbook = getAllNewspapers();
        for (Newspaper n : listbook) {
            if (newspaper.getNameNXB().equals(n.getNameNXB())) {
                return n;
            }
        }
        return null;
    }
}
