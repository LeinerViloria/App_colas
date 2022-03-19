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
    private static final String[] opciones = {"Ver tamaño de la cola", "Ver informacion", "Salir"};
    private static String mensaje = "Seleccione una opcion del menu:";
    
    private static void cargarMensaje(){
        int numeroOpcion = 1;
        for (String opcion : AppCola.opciones) {
            AppCola.mensaje += "\n"+numeroOpcion+". "+opcion;
            numeroOpcion++;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cargarMensaje();
        Cola cola = new Cola();
        generarCola(cola);
        
        int option = optionsMenu();
        do{
            switch(option){
                case 1:
                    JOptionPane.showMessageDialog(null, "TIene un tamaño de "+cola.getNumPersonas()+" maximo");
                    option = optionsMenu();
                    break;
                case 2:
                    cola.showAll();
                    option = optionsMenu();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Que tenga buen dia");
                    break;
            }
        }while(option!=AppCola.opciones.length);
        
    }
    
    private static void generarCola(Cola cola){
        final int size = cola.getNumPersonas();
        
        for(int i=0; i<size; i++){
            Nodo nuevoNodo = new Nodo();
            generarPersona(nuevoNodo);
            nuevoNodo.setPrecio(cola.precioSegunEdad(nuevoNodo.getPersona()));
            
            cola.agregar(nuevoNodo);
            
            
        }
    }
    
    //Metodo para llenar la lista enlazada
    public static void generarPersona(Nodo nodo){
        Persona nuevaPersona = new Persona();
        nuevaPersona.setEdad(generarEdad());
        nodo.setPersona(nuevaPersona);
        
    }
    
    private static int generarEdad(){
        int edad = 0;
        boolean flag = false;
        do{
            edad = (int) (Math.random() * 100);
            if(edad>=5 && edad<=60) flag=true;
        }while(!flag);
        
        return edad;
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
    
    public static int optionsMenu(){
        int option = 0;
        
        
        do {            
            option = Integer.parseInt(validString(AppCola.mensaje, true, false));
        } while (option < 1 || option>AppCola.opciones.length);
        
        return option;
    }
    
}
