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
import Document.Jounary;
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
public class ManagerJounary {
    public List<Jounary> getAllJounarys() throws SQLException {
        List<Jounary> jounarys = new ArrayList<Jounary>();

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from jounary";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Jounary jounary = new Jounary();
                jounary.setIdTL(rs.getInt("idTL"));
                jounary.setId(rs.getInt("id"));
                jounary.setNameNXB(rs.getString("nameNXB"));
                jounary.setMonth(rs.getInt("monthXB"));
                jounary.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                jounarys.add(jounary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jounarys;
    }
    public Jounary getJounaryById(int id) throws SQLException {

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from jounary where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Jounary jounary = new Jounary();
                jounary.setIdTL(rs.getInt("idTL"));
                jounary.setId(rs.getInt("id"));
                jounary.setNameNXB(rs.getString("nameNXB"));
                jounary.setMonth(rs.getInt("monthXB"));
                jounary.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                
                return jounary;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addJounary (Jounary Jounary) throws SQLException {
        Connection connection =  ConnectDatabase.getConnectionDatabase();
        String sql="Insert into jounary(idTL, id, nameNXB, monthXB, soBanPhatHanh)" 
                + "Values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Jounary.getIdTL());
            preparedStatement.setInt(2, Jounary.getId());
            preparedStatement.setString(3, Jounary.getNameNXB());
            preparedStatement.setInt(4, Jounary.getMonth());
            preparedStatement.setInt(5, Jounary.getSoBanPhatHanh());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateJounary (Jounary Jounary) throws SQLException{
        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "Update jounary set nameNXB = ? , monthXB = ? , soBanPhatHanh = ? where id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Jounary.getNameNXB());
            preparedStatement.setInt(2, Jounary.getMonth());
            preparedStatement.setInt(3, Jounary.getSoBanPhatHanh());
            preparedStatement.setInt(4, Jounary.getId());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteJounary (int id) throws SQLException{
       Connection connection = ConnectDatabase.getConnectionDatabase();
       String sql = "delete from jounary where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Jounary findJounary(Jounary jounary) throws SQLException {
        List<Jounary> listjounary = new ArrayList<>();
        listjounary = getAllJounarys();
        for (Jounary j : listjounary) {
            if (jounary.getNameNXB().equals(j.getNameNXB())) {
                return j;
            }
        }
        return null;
    }
}
