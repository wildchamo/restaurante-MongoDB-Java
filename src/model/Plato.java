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
 * @author David
 */
public class Plato extends BasicDBObject {

    private final String NOMBRE = "nombreplato";
    private final String CALORIAS = "calorias";
    private final String VALOR_REAL = "valor_real";
    private final String VALOR_COMERCIAL = "valor_comercial";
    private final String RECETA = "receta";
    private final String INGREDIENTES = "ingrediente";


    private boolean partial;

    public Plato() {
        partial = false;
    }

    public Plato(String nombreplato, double calorias, double valor_real, double valor_comercial, String receta,LinkedList<Ingrediente> ingredientes) {

        this.put(NOMBRE, nombreplato);
        this.put(CALORIAS, calorias);
        this.put(VALOR_REAL, valor_real);
        this.put(VALOR_COMERCIAL, valor_comercial);
        this.put(RECETA, receta);
        this.put(INGREDIENTES, ingredientes);
        this.markAsPartialObject();
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(NOMBRE);
        setThis.add(CALORIAS);
        setThis.add(VALOR_REAL);
        setThis.add(VALOR_COMERCIAL);
        setThis.add(RECETA);
        setThis.add(INGREDIENTES);

        partial = !set.equals(setThis);
    }

    public boolean isPartialObject() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

    public String getNombreP() {
        return this.getString(NOMBRE);
    }

    public void setNombreP(String nombreplato) {
        this.put(NOMBRE, nombreplato);
    }

    public String getCalorias() {
        return this.getString(CALORIAS);
    }

    public void setCalorias(double calorias) {
        this.put(CALORIAS, calorias);
    }

    public String getValorR() {
        return this.getString(VALOR_REAL);
    }

    public void setValorR(double valor_real) {
        this.put(VALOR_REAL, valor_real);
    }
    public String getValorC() {
        return this.getString(VALOR_COMERCIAL);
    }

    public void setValorC(double valor_comercial) {
        this.put(VALOR_COMERCIAL, valor_comercial);
    }
    
    public String getReceta() {
        return this.getString(RECETA);
    }

    public void setReceta(String receta) {
        this.put(RECETA, receta);
    }
    
        
}
