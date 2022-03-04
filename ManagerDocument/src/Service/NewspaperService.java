/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Document.Newspaper;
import Manager.ManagerNewspaper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AD
 */
public class NewspaperService {
    private ManagerNewspaper ManagerNewspaper;
    public NewspaperService(){
        ManagerNewspaper = new ManagerNewspaper();
    }
    public List<Newspaper> getAllNewspapers() throws SQLException{
        return ManagerNewspaper.getAllNewspapers();
    }
    public void addNewspaper(Newspaper newspaper) throws SQLException{
        ManagerNewspaper.addNewspaper(newspaper);
    }
    public void deleteNewspaper(int id) throws SQLException{
        ManagerNewspaper.deleteNewspaper(id);
    }
    public Newspaper getNewspaperById(int id) throws SQLException{
        return ManagerNewspaper.getNewspaperById(id);
    }
    public void updateNewspaper(Newspaper newspaper) throws SQLException{
        ManagerNewspaper.updateNewspaper(newspaper);
    }
    public Newspaper findNewspaper(Newspaper book) throws SQLException{
        return ManagerNewspaper.findNewspaper(book);
    }
}
