/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    private int Ninscipcion;
    private String Nombre;
    private String propietario;
    private String raza;
    private boolean estado;
    
    public Filtro() {
    }

    public Filtro(int id, String codigo, String marca, String stock, boolean estado) {
        this.Ninscipcion = id;
        this.Nombre = codigo;
        this.propietario = marca;
        this.raza = stock;
        this.estado = estado;
    }

    public Filtro(String codigo, String marca,String stock, boolean estado) {
        this.Nombre = codigo;
        this.propietario = marca;
        this.raza=stock;
        this.estado = estado;
    }

    public Filtro(String marca, String stock, boolean estado) {
        this.propietario = marca;
        this.raza = stock;
        this.estado = estado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getNinscipcion() {
        return Ninscipcion;
    }

    public void setNinscipcion(int Ninscipcion) {
        this.Ninscipcion = Ninscipcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public boolean isEstado() {
        return estado;
    }

    

    public boolean getExixtencia() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
