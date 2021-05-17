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
 * @author dacastro
 */
public class Chef extends BasicDBObject {

    private final String NOMBRE = "nombrechef";
    private final String EXPERIENCIA = "experiencia";
    private final String CORREO = "correo";
    private final String TELEFONO = "telefono";
    private boolean partial;

    public Chef() {
        partial = false;
    }

    public Chef(String nombrechef, int experiencia, String correo, String telefono) {

        this.put(NOMBRE, nombrechef);
        this.put(EXPERIENCIA, experiencia);
        this.put(CORREO, correo);
        this.put(TELEFONO, telefono);

        this.markAsPartialObject();
    }

    @Override
    public void markAsPartialObject() {
        Set<String> set = keySet();
        set.remove("_id");

        Set<String> setThis = new HashSet<String>();
        setThis.add(NOMBRE);
        setThis.add(EXPERIENCIA);
        setThis.add(CORREO);
        setThis.add(TELEFONO);

        partial = !set.equals(setThis);
    }

    public boolean isPartialObject() {
        return partial;
    }

    public void setPartial(boolean partial) {
        this.partial = partial;
    }

}
