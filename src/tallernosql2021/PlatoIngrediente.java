/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallernosql2021;

import model.Plato;
import model.Ingrediente;
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
public class PlatoIngrediente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ingrediente obji = new Ingrediente("nombregenerico","cantidad generica","miligramos");

        Plato objp = new Plato("nombreplato", 15, 300, 400,"de la abuela", obji);

        BaseDatos objbd = new BaseDatos();
        
        try {
            DB objb= objbd.createConnection();
            if (objb != null) {
                DBCollection collection= objb.getCollection(objp.getClass().getSimpleName());
                collection.insert(objp);
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(TallerNoSQL2021.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
