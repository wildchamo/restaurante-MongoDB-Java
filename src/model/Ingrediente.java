/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mongodb.BasicDBObject;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author wild.chamo
 */
public class Ingrediente extends BasicDBObject {

    private final String NOMBRE = "nombreIngrediente";
    private final String CANTIDAD = "cantidadIngrediente";
    private final String MEDIDA = "medidaIngrediente";
    private boolean partial;

    public Ingrediente() {
        partial = false;
    }

    public Ingrediente(String nombreIngrediente, Double cantidadIngrediente,  String medidaIngrediente) {
        //clave y valor
        this.put(NOMBRE, nombreIngrediente);
        this.put(CANTIDAD, cantidadIngrediente);
        this.put(MEDIDA, medidaIngrediente);

        this.markAsPartialObject();
    }

    
    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(NOMBRE);
        setThis.add(CANTIDAD);
        setThis.add(MEDIDA);

        partial = !set.equals(setThis);
    }

    public boolean isPartialObject() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }
}
