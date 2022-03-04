/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Document.Jounary;
import Manager.ManagerJounary;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AD
 */
public class JounaryService {
    private ManagerJounary ManagerJounary;
    public JounaryService(){
        ManagerJounary = new ManagerJounary();
    }
    public List<Jounary> getAllJounarys() throws SQLException{
        return ManagerJounary.getAllJounarys();
    }
    public void addJounary(Jounary jounary) throws SQLException{
        ManagerJounary.addJounary(jounary);
    }
    public void deleteJounary(int id) throws SQLException{
        ManagerJounary.deleteJounary(id);
    }
    public Jounary getJounaryById(int id) throws SQLException{
        return ManagerJounary.getJounaryById(id);
    }
    public void updateJounary(Jounary jounary) throws SQLException{
        ManagerJounary.updateJounary(jounary);
    }
    public Jounary findJounary(Jounary jounary) throws SQLException{
        return ManagerJounary.findJounary(jounary);
    }
}
