/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appCola;

/**
 *
 * @author leine
 */
public class Cola {
    private final int numPersonas;
    private int precios[];
    private Nodo frente;
    private Nodo nodoFinal;

    public Cola() {
        this.numPersonas = this.generateSize();
        this.precios = new int[4];
        this.generarPrecios();
    }
    
    private int generateSize(){
        int size = 0;
        
        do{
            size = (int) (Math.random() * 100);
        }while(size<0 || size>50);
        
        return size;
    }
    
    private void generarPrecios(){
        /*
        0 -> Precio infantil
        1 -> Precio juvenil
        2 -> Precio Adulto
        3 -> Precio Adulto mayor
        */
        this.precios[0] = 6000;
        this.precios[1] = 15000;
        this.precios[2] = 25000;
        this.precios[3] = 20000;
    }

    public int getNumPersonas() {
        return numPersonas;
    }
    
    public int precioSegunEdad(Persona persona){
        int edad = persona.getEdad();
        int precio = 0;
        
        if(edad<14){
            precio = this.precios[0];
        }else if(edad<18){
            precio = this.precios[1];
        }else if(edad<45){
            precio = this.precios[2];
        }else{
            precio = this.precios[3];
        }
        
        
        return precio;
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(Nodo nodoFinal) {
        this.nodoFinal = nodoFinal;
    }
    
    
    
    
}
