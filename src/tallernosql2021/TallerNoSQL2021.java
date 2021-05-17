/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallernosql2021;
import model.Chef;
import model.Menu;

/**
 *
 * @author David
 */
public class TallerNoSQL2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Chef objc= new Chef("Jose luis",5,"joselo@uao.edu.co","1111");
       
       Menu objm= new Menu("comida mexicana", true, "12-2011","30-2020",objc);
    }
    
}
