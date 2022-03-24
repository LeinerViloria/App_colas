/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appCola;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static org.apache.commons.lang3.StringUtils.isEmpty;

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
        String mensaje = "";
        while(temp != null){
            mensaje += "#"+orden+") Esta persona tiene "+temp.getPersona().getEdad()+" años, su entrada vale "+temp.getPrecio()+"\n";
            
            temp = temp.getSiguiente();
            orden++;
        }
       
        JTextArea textArea = new JTextArea(mensaje);
JScrollPane scrollPane = new JScrollPane(textArea);  
textArea.setLineWrap(true);  
textArea.setWrapStyleWord(true); 
scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
JOptionPane.showMessageDialog(null, scrollPane, "Personas que entraron al Cine",  
                                       JOptionPane.YES_NO_OPTION);
    }
    
     public void showTotal(){
        Nodo temp = this.frente;
        int orden = 1;
        int recaudacion=0;
        while(temp != null){
           
            recaudacion+=temp.getPrecio();
            temp = temp.getSiguiente();
            orden++;
        }
        JOptionPane.showMessageDialog(null, "La recaudacion total fue de: "+recaudacion);
    }

    }


