package adivinarnumeromaquina;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class AdivinarNumeroMaquina {

    // guarda el numero máximo que se puede adivinar y el numero de intentos
    private int MAX_NUM;
    private int NUM_INTENTOS;

    // guarda el nombre del jugador, el numero que ha pensado la maquina y los numeros que intenta el jugador
    public String nombre;
    public int numeromaquina;
    public int numerosjugador[] = new int[100];
    
    // guarda si se aciertan y el numero de intentos en el que se ha acertado
    public boolean acertado = false;
    public int intentosacertado = 0;

    // el area de salida final
    public JTextArea salida = new JTextArea();

    public AdivinarNumeroMaquina() {
        // obtenemos el nombre del jugador
        nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
        // obtener el numero maximo
        MAX_NUM = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero maximo:"));
        // obtener el numero maximo
        NUM_INTENTOS = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de intentos:"));        
        // calcular el numero de la maquina
        numeromaquina = (int) (Math.random() * MAX_NUM + 1);
        // juego de adivinacion de datos
        adivinar();
        // sacar los datos por pantalla
        salidaDatos();
    }

    public void adivinar() {

        boolean continuar = true;
        int intento = 1;
        while (continuar && intento <= NUM_INTENTOS) {
            
                // calculo de los numeros que introduce el jugador
                String strjugador = JOptionPane.showInputDialog("Intento " +intento + " Introduce un numero del 1 al " + MAX_NUM);
                numerosjugador[intento-1] = Integer.parseInt(strjugador);

                String resultado = new String();
                if (numerosjugador[intento-1] == numeromaquina) {
                    resultado = " Acertaste";
                    continuar = false;
                    acertado = true;
                    intentosacertado = intento;
                } else if (numerosjugador[intento-1] < numeromaquina) {
                    resultado = " Has fallado, el numero es mayor";
                } else {
                    resultado = " Has fallado, el numero es menor";
                }
                JOptionPane.showMessageDialog(null, resultado, "Resultado Tirada", JOptionPane.INFORMATION_MESSAGE);
                intento++;
        } // FIN WHILE
    }

    public void salidaDatos() {
        salida.append("Nombre de jugador " + nombre + "\n");
        salida.append("Numero maximo de intentos " +NUM_INTENTOS + "\n");
        salida.append("Numero mayor posible " +MAX_NUM + "\n");
        salida.append("Numero adivinar " + numeromaquina + "\n");

        for (int i = 0; i < NUM_INTENTOS; i++) {
            if (i+1 <= intentosacertado || !acertado ) {
                salida.append("Intento " + (i + 1)+ "\tNumero jugador " + numerosjugador[i] + "\n");
            }
         }
        
        
        if (acertado) {
            salida.append("Has acertado en " +intentosacertado + " intentos");
        }
        else {
            salida.append("No has acertado");
        }
     
        JOptionPane.showMessageDialog(null, salida, "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
    }

}
