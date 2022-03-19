/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appCola;

import javax.swing.JOptionPane;
import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 *
 * @author leine
 */
public class AppCola {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola cola = new Cola();
        Nodo aux;
        
        int option = optionsMenu();
        do {                     
            switch(option){
                
            }
        } while (option!=1);
    }
    
    //Metodo para llenar la lista enlazada
    public static void fill(Nodo node){
        
        
    }

    
    /**
     *
     * @param message, es el mensaje que quiera mostrar
     * @param numericValidation, para distinguir entre String y variables 
     *                           numericas
     * @param isFloatNumber, para saber si es un numero flotante y se 
     *                       necesite su punto decimal
     * @return
     */
    public static String validString(final String message, final boolean numericValidation, final boolean isFloatNumber){
        String value=null;
        boolean flag; //Por si necesita validacion numerica
        do {            
            value = JOptionPane.showInputDialog(message);
            //La funcion trim limpia los espacios a la izquierda y derecha
            value = value.trim();
            //Si necesita validacion numerica verifica que lo ingresado sea un numero
            flag = numericValidation ? isNumeric(value, isFloatNumber) : true;
        } while (value.contentEquals("") || !flag);
        
        return value;
    }
    
    //Se cogio la funcion de la libreria StringUtils
    //Se adaptará para que admita flotantes
    public static boolean isNumeric(final CharSequence cs, boolean isFloatNumber) {
       if (isEmpty(cs)) {
           return false;
       }
       final int sz = cs.length();
       
       String ourCharacter;//Se lo agregue
       boolean decimalFound = false;//Se lo agregue
       //Le agregue isFloatNumber
       
       for (int i = 0; i < sz; i++) {
           //Creo ourCharacter para tener acceso a metodos de String
            ourCharacter = Character.toString(cs.charAt(i));//Se lo agregue
            if (!Character.isDigit(cs.charAt(i))) {
                //Le agregue desde aqui
                if(ourCharacter.contentEquals(".") && isFloatNumber && !decimalFound){
                    decimalFound = true;
                }else{
                    return false;
                }
                //Hasta aqui
            }
        }

       return true;
   }
    
    public static void show(Nodo node){
        
    }
    
    //Metodo para listar uno a uno los nodos de la lista
    public static void nodeList(Nodo node){
        Nodo temp = node;
        //while (temp != null) { show(temp); temp = temp.getNext(); }   
    }
    
    public static int optionsMenu(){
        int option = 0;
        
        do {            
            option = Integer.parseInt(validString("Seleccione una opcion del menu:\n"+
                                                  "1. Salir", true, false));
        } while (option < 1 || option>1);
        
        return option;
    }
    
}
