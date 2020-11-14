package adivinarnumerojugador;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class AdivinarNumeroJugador {

    // guarda el nombre del jugador, el numero que ha pensado la maquina y los numeros que intenta el jugador
    public String nombre;
  
    public int maximo=100;
    public int minimo=1;
    public int solucion;
    public int intentos=0;
    
    // el area de salida final
    public JTextArea bienvenida = new JTextArea();
    public JTextArea fin = new JTextArea();
    
    public AdivinarNumeroJugador() {
         // obtenemos el nombre del jugador
        nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
        // Escoje un numero del 1 al 100
        bienvenida.append("Bienvenido. ");
        bienvenida.append(nombre);
        bienvenida.append(" \n Escoje un numero del 1 al 100. \n Voy a adivinarlo \n");
        JOptionPane.showMessageDialog(null, bienvenida, "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
        // juego de adivinacion de datos
        adivinar();
        // sacar los datos por pantalla
        salidaDatos();
    }
    
    public void adivinar() {
        
        solucion = calcularnumero(minimo,maximo);
        int opcion= pedirnumero();
        
      boolean acierto = false;
        while (!acierto) {
            intentos++;
            if (opcion == 1) {
                maximo = solucion;
                solucion = calcularnumero(minimo,maximo);         
                opcion = pedirnumero(); 
             } 
            else if (opcion == 2) {
                fin.append("La solucion era " +solucion);
                fin.append("\n Conseguido en " +intentos + " intentos \n");
                    acierto = true;    
            } 
            else if (opcion == 3) {
                 minimo = solucion;
                solucion = calcularnumero(minimo,maximo);         
                opcion = pedirnumero();                
            } 
              
        } // FIN WHILE
     
    }
    
    public int pedirnumero() {
        int tmp=Integer.parseInt(JOptionPane.showInputDialog("Es el numero " +solucion + "\n" + 
                "Si es menor, introduce 1 \n" + 
                 "Si es correcto, introduce 2 \n " +
                "Si es mayor, introduce 3 \n"));
        return tmp;
    }
    public int calcularnumero(int min, int max) {
        int media = (int) (max + min)/2;
        return media;
    }
    public void salidaDatos() {
        fin.append("Fin del programa.  \n");
        fin.append(nombre + " Lo has hecho muy bien ");
        
        JOptionPane.showMessageDialog(null, fin, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        
    }
}