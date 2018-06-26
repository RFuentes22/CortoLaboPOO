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
    private String Ninscipcion;
    private String Nombre="";
    private String propietario;
    private int edad;
    private String raza;
    private boolean estado;
    
    public Filtro() {
    }

    public Filtro(String Ninscipcion, String Nombre, String propietario,int edad, String raza, boolean estado) {
        this.Ninscipcion = Ninscipcion;
        this.Nombre = Nombre;
        this.propietario = propietario;
        this.raza = raza;
        this.estado = estado;
    }

    public Filtro(String Nombre, String propietario,String raza, boolean estado) {
        this.Nombre = Nombre;
        this.propietario = propietario;
        this.raza=raza;
        this.estado = estado;
    }

    public Filtro(String propietario, String raza, boolean estado) {
        this.propietario = propietario;
        this.raza = raza;
        this.estado = estado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNinscipcion() {
        return Ninscipcion;
    }

    public void setNinscipcion(String Ninscipcion) {
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Filtro{" + "Ninscipcion=" + Ninscipcion + ", Nombre=" + Nombre + ", propietario=" + propietario + ", edad=" + edad + ", raza=" + raza + ", estado=" + estado + '}';
    }
    
    
}
