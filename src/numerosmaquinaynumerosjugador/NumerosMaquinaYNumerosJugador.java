package numerosmaquinaynumerosjugador;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class NumerosMaquinaYNumerosJugador {

    private static final int MAX_NUM = 10;
    private static final int NUM_REPET = 10;

    public String nombre;
    public JTextArea salida = new JTextArea();
    public int numerosmaquina[] = new int[MAX_NUM];
    public int numerosjugador[] = new int[MAX_NUM];
    public int puntos[] = new int[MAX_NUM];
    public int ordenado[] = new int[MAX_NUM];

    public NumerosMaquinaYNumerosJugador() {
        // obtenemos el nombre del jugador
        nombre = JOptionPane.showInputDialog("Introduce tu nombre:");

        // juego de adivinacion de datos
        adivinar();

        // ordenar los numeros de la maquina
        ordenarMaquina();
        // sacar los datos por pantalla
        salidaDatos();

        
    }

    public void adivinar() {

        for (int i = 0; i < NUM_REPET; i++) {

            // calculo de los numeros de la maquina
            numerosmaquina[i] = (int) (Math.random() * MAX_NUM + 1);

            // calculo de los numeros que introduce el jugador
            String strjugador = JOptionPane.showInputDialog("Ronda " + (i + 1) + " Introduce un numero del 1 al " +MAX_NUM );
            numerosjugador[i] = Integer.parseInt(strjugador);

            String resultado = "El numero de la maquina es " + numerosmaquina[i];

            if (numerosjugador[i] == numerosmaquina[i]) {
                resultado = resultado + " Has acertado";
                if (i == 0) {
                    puntos[i] = 1;
                }
                else {
                    puntos[i] = puntos[i-1] + 1;
                } 
            } else {
                resultado = resultado + " Has fallado";
                if (i == 0) {
                    puntos[i] = 0;
                }
                else {
                    puntos[i] = puntos[i-1];
                } 
            }
            JOptionPane.showMessageDialog(null, resultado, "Resultado Tirada", JOptionPane.INFORMATION_MESSAGE);
        } // final for

    }
 
    public void ordenarMaquina() {
        // copio el array sin ordenar
        for (int i = 0; i < MAX_NUM; i++) {
            ordenado[i] =  numerosmaquina[i];
        }
        
        // ordenar el array
        int auxiliar;
        
        for (int j = 0; j < MAX_NUM-1; j++) {
            for (int jj = j+1; jj < MAX_NUM; jj++) {
              
                if (ordenado[j] > ordenado[jj]) {
                    auxiliar = ordenado[j];
                    ordenado[j] = ordenado[jj];
                    ordenado[jj] = auxiliar;
                }
            }
        }
        
    }
    public void salidaDatos() {
        salida.append("Nombre de jugador " +nombre + "\n");
        
        for (int i = 0; i < NUM_REPET; i++) {
            salida.append("Tirada " +(i+1));
            salida.append("\tNumero jugador " + numerosjugador[i]);
            salida.append("\tNumero maquina " + numerosmaquina[i]);
            salida.append("\tLlevas " +puntos[i] + " puntos" + "\n");
        }

        salida.append("Numeros de la maquina ordenados" + "\n" );
        for (int i = 0; i < NUM_REPET; i++) {
            salida.append(ordenado[i] + " ");
        }
        
        
        JOptionPane.showMessageDialog(null, salida, "RESULTADO", JOptionPane.INFORMATION_MESSAGE);

    }

}