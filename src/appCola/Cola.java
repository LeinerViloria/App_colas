/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appCola;

import javax.swing.JOptionPane;

/**
 *
 * @author leine
 */
public class Cola {
    private final int numPersonas;
    private final int precios[];
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
    
    public int getSize(){
        Nodo temp = this.frente;
        int size = 0;
        
        while(temp!=null){
            size++;
            temp = temp.getSiguiente();
        }
        
        return 0;
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
    
    public void agregar(Nodo nuevoNodo){
        
        if(this.getSize()<this.numPersonas){
            if(getFrente()==null){
                this.setFrente(nuevoNodo);
                this.setNodoFinal(nuevoNodo);
            }else{
                Nodo temp = getNodoFinal();
                temp.setSiguiente(nuevoNodo);
                this.setNodoFinal(nuevoNodo);
            }
        }else{
            JOptionPane.showMessageDialog(null, "La cola está llena.");
        }
        
    }
    
    public void showAll(){
        Nodo temp = this.frente;
        int orden = 1;
        while(temp != null){
            String mensaje = "#"+orden+") Esta persona tiene "+temp.getPersona().getEdad()+" años, su entrada vale "+temp.getPrecio();
            
            JOptionPane.showMessageDialog(null, mensaje);
            
            temp = temp.getSiguiente();
            orden++;
        }
        
    }
    
    
}
