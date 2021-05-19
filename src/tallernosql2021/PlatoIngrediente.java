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
import java.util.LinkedList;

/**
 *
 * @author David
 */
public class PlatoIngrediente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*  Ingrediente obji = new Ingrediente("nombregenerico",1.1,"miligramos");
        LinkedList<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
        ingredientes.add(obji);
        ingredientes.add(obji);
        ingredientes.add(obji);
        Plato objp = new Plato("nombreplato", 15, 300, 400,"de la abuela",ingredientes );
         */        
        BaseDatos objbd = new BaseDatos();
        Plato objpp=new Plato();
        LinkedList<Plato> listaP;
        
        try {
            DB objb = objbd.createConnection();
            if (objb != null) {
//                DBCollection collection= objb.getCollection(objp.getClass().getSimpleName());
//                collection.insert(objp);

                listaP = (LinkedList<Plato>)objbd.findAll(objpp.getClass());
                
                for(int i=0; i<listaP.size();i++){
                    Plato get = listaP.get(i);
                    System.out.println("datos " + get.toJson()+"\n");
                }
                
                
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(TallerNoSQL2021.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
