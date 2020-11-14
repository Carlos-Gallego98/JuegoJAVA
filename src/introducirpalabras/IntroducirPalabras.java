package introducirpalabras;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class IntroducirPalabras {

    // un texto donde voy a guardar la salida
   public JTextArea areaSalida = new JTextArea();
    // las palabras que deseo calcular
    public String palabras[] = new String[10];
    // las palabras ordenadas
    public String ordenado[] = new String[10];
    // las palabras ordenadas descendente
    public String descendente[] = new String[10];
    // las palabras ordenadas por longitud
    public String longitud[] = new String[10];
    
    public IntroducirPalabras() {
        JOptionPane.showMessageDialog(null,  " Tienes que introducir 10 nombres \n de uno en uno",   "Hola Carlos", JOptionPane.INFORMATION_MESSAGE);
        // juego de introducir Palabras
        introducirPalabras();
        // ordenarBurbuja
        ordenarBurbujaPorNombre();      
        // ordenarBurbuja Descendente
        ordenarBurbujaDescendente(); 
        // ordenarBurbuja Longitud
        ordenarBurbujaLongitud(); 
        // sacar los datos por pantalla
        salida();
    }

    public void introducirPalabras() {
      
        for (int i = 0; i < palabras.length; i++) {
            // las palabras que introduce el jugador
            palabras[i] = JOptionPane.showInputDialog("Introduce un nombre , intento " +(i+1));  
        }
    }

    public void ordenarBurbujaPorNombre() {
        
        // copiar el array
        for (int i = 0; i < palabras.length; i++) {
            ordenado[i] = palabras[i];
        }
        
        String auxiliar;
        
        // ordenar el array
        for (int i = 0; i < ordenado.length-1; i++) {
            for (int j = i+1; j < ordenado.length; j++) {
                //comparamos elementos uno a uno y los intercambiamos
                // si el elemento actual es mayor que el siguiente
                if (ordenado[i].compareTo(ordenado[j]) > 0) {
                    auxiliar = ordenado[i];
                    ordenado[i] = ordenado[j];
                    ordenado[j] = auxiliar;
                }//Fin ciclo controlamos numero de comparaciones
            }//Fin ciclo controlamos numero de pasadas
        }//Fin metodo ordenarBurbuja
    }
    
     public void ordenarBurbujaDescendente() {
        
        // copiar el array
        for (int i = 0; i < palabras.length; i++) {
            descendente[i] = palabras[i];
        }
        
        String auxiliar;
        
        // ordenar el array
        for (int i = 0; i < descendente.length-1; i++) {
            for (int j = i+1; j < descendente.length; j++) {
                //comparamos elementos uno a uno y los intercambiamos
                // si el elemento actual es mayor que el siguiente
                if (descendente[i].compareTo(descendente[j]) < 0) {
                    auxiliar = descendente[i];
                    descendente[i] = descendente[j];
                    descendente[j] = auxiliar;
                }//Fin ciclo controlamos numero de comparaciones
            }//Fin ciclo controlamos numero de pasadas
        }//Fin metodo ordenarBurbuja
    }

       public void ordenarBurbujaLongitud() {
        
        // copiar el array
        for (int i = 0; i < palabras.length; i++) {
            longitud[i] = palabras[i];
        }
        
        String auxiliar;
        
        // ordenar el array
        for (int i = 0; i < longitud.length-1; i++) {
            for (int j = i+1; j < longitud.length; j++) {
                //comparamos elementos uno a uno y los intercambiamos
                // si el elemento actual es mayor que el siguiente
                if ( longitud[i].length() < longitud[j].length()) {
                    auxiliar = longitud[i];
                    longitud[i] = longitud[j];
                    longitud[j] = auxiliar;
                }//Fin ciclo controlamos numero de comparaciones
            }//Fin ciclo controlamos numero de pasadas
        }//Fin metodo ordenarBurbuja
    }
       
    public void salida() {
        areaSalida.append("Palabras sin ordenar.  \n");
        for (int i=0; i<palabras.length; i++) {
            areaSalida.append((i+1) + " " +palabras[i] + "\n");
        }
        JOptionPane.showMessageDialog(null, areaSalida, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        areaSalida = new JTextArea();
        areaSalida.append("Palabras ordenadas.  \n");
        for (int i=0; i<ordenado.length; i++) {
            areaSalida.append((i+1) + " " +ordenado[i] + "\n");
        }
        JOptionPane.showMessageDialog(null, areaSalida, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        areaSalida = new JTextArea();
        areaSalida.append("Palabras ordenadas descendente.  \n");
        for (int i=0; i<descendente.length; i++) {
            areaSalida.append((i+1) + " " +descendente[i] + "\n");
        }
        JOptionPane.showMessageDialog(null, areaSalida, "Resultado", JOptionPane.INFORMATION_MESSAGE);
        areaSalida = new JTextArea();
        areaSalida.append("Palabras ordenadas por longitud.  \n");
        for (int i=0; i<longitud.length; i++) {
            areaSalida.append((i+1) + " " +longitud[i] + "\n");
        }
        JOptionPane.showMessageDialog(null, areaSalida, "Resultado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
