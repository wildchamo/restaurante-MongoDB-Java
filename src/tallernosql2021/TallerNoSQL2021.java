/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallernosql2021;

import model.Chef;
import model.Menu;
import com.mongodb.DB;
import BD.BaseDatos;
import com.mongodb.DBCollection;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class TallerNoSQL2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chef objc = new Chef("Jose luis", 5, "joselo@uao.edu.co", "1111");

        Menu objm = new Menu("comida mexicana", true, "12-2011", "30-2020", objc);

        BaseDatos objbd = new BaseDatos();
        
        try {
            DB objb= objbd.createConnection();
            if (objb != null) {
                DBCollection collection= objb.getCollection(objm.getClass().getSimpleName());
                collection.insert(objm);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(TallerNoSQL2021.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
