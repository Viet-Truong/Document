/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Document.Book;
import Manager.ManagerBook;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AD
 */
public class BookService {
    private ManagerBook ManagerBook;
    public BookService(){
        ManagerBook = new ManagerBook();
    }
    public List<Book> getAllBooks() throws SQLException{
        return ManagerBook.getAllBooks();
    }
    public void addBook(Book book) throws SQLException{
        ManagerBook.addBook(book);
    }
    public void deleteBook(int id) throws SQLException{
        ManagerBook.deleteBook(id);
    }
    public Book getBookById(int id) throws SQLException{
        return ManagerBook.getBookById(id);
    }
    public void updateBook(Book book) throws SQLException{
        ManagerBook.updateBook(book);
    }
    public Book findBook(Book book) throws SQLException{
        return ManagerBook.findBook(book);
    }
}
