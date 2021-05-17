/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author wild.chamo
 */
public class Ingrediente {

    private final String NOMBRE = "nombreIngrediente";
    private final String CANTIDAD = "cantidadIngrediente";
    private final String MEDIDA = "medidaIngrediente";
    private boolean partial;

    public Ingrediente() {
        partial = false;
    }
}
