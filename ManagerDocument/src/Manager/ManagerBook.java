/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

/**
 *
 * @author AD
 */
import Document.Book;
import Document.ConnectDatabase;
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
public class ManagerBook {
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<Book>();

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from book";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setIdTL(rs.getInt("idTL"));
                book.setNameNXB(rs.getString("nameNXB"));
                book.setNameAuthor(rs.getString("nameAuthor"));
                book.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                book.setPage(rs.getInt("pageBook"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
    
    public Book getBookById(int id) throws SQLException {

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from book where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setIdTL(rs.getInt("idTL"));
                book.setNameAuthor(rs.getString("nameNXB"));
                book.setNameNXB(rs.getString("nameAuthor"));
                book.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                book.setPage(rs.getInt("pageBook"));
                
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    

    public void addBook(Book book) throws SQLException {
        Connection connection =  ConnectDatabase.getConnectionDatabase();
        String sql = "Insert into book(idTL, nameNXB, nameAuthor, soBanPhatHanh, pageBook)"
                + "Values(?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getIdTL());
            preparedStatement.setString(2, book.getNameNXB());
            preparedStatement.setString(3, book.getNameAuthor());
            preparedStatement.setInt(4, book.getSoBanPhatHanh());
            preparedStatement.setInt(5, book.getPage());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateBook(Book book) throws SQLException{
        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "Update book set nameNXB = ?, nameAuthor = ?, pageBook = ?, soBanPhatHanh = ? Where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getNameNXB());
            preparedStatement.setString(2, book.getNameAuthor());
            preparedStatement.setInt(3, book.getPage());
            preparedStatement.setInt(4, book.getSoBanPhatHanh());
            preparedStatement.setInt(5, book.getIdTL());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteBook(int id) throws SQLException{
       Connection connection = ConnectDatabase.getConnectionDatabase();
       String sql = "delete from book where idTL = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Book findBook(Book book) throws SQLException {
        List<Book> listbook = new ArrayList<>();
        listbook = getAllBooks();
        for (Book s : listbook) {
            if (book.getNameNXB().equals(s.getNameNXB())) {
                return s;
            }
        }
        return null;
    }
}
