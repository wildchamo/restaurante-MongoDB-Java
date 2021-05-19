/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mongodb.BasicDBObject;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author wildChamo
 */
public class Menu extends BasicDBObject{
    
    private final String NOMBRE = "nombremenu";
    private final String VIGENTE = "vigente";
    private final String FECHAINICIO = "fechainicio";
    private final String FECHAFIN   = "fechafin";
    private final String CHEF   = "chef";
    private final String PLATOS   = "platos";
    
    private boolean partial;

    public Menu() {
        partial = false;
    }

    public Menu(String nombremenu, String vigente, String fechainicio, String fechaFin, Chef chef, LinkedList<String> platos) {
        
        this.put(NOMBRE, nombremenu);
        this.put(VIGENTE, vigente);
        this.put(FECHAINICIO, fechainicio);
        this.put(FECHAFIN, fechaFin);
        this.put(CHEF, chef);
        this.put(PLATOS,platos);
        this.markAsPartialObject();
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(NOMBRE);
        setThis.add(VIGENTE);
        setThis.add(FECHAINICIO);
        setThis.add(FECHAFIN);
        setThis.add(CHEF);

        partial = !set.equals(setThis);
    }

    public boolean isPartialObject() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }
    
     /**
     * Get the value of identificacion
     *
     * @return the value of identificacion
     */
    public String getNombreM() {
        return this.getString(NOMBRE);
    }

    /**
     * Set the value of identificacion
     *
     * @param identificacion new value of identificacion
     */
    public void setNombrMenui(String nombremenu) {
        this.put(NOMBRE, nombremenu) ;
    }
}
