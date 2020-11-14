package calculadorasimple;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class CalculadoraSimple {

    // guarda el nombre del jugador, el numero que ha pensado la maquina y los numeros que intenta el jugador
    public String nombre;

    // calcula el numero de intentos
    private int NUM_INTENTOS;
    public int numeros[] = new int[100];
    
    // suma de raiz cuadrado y cuadrado
    public double acumraizcuadrada = 0;
    public double acumcuadrado = 0;

    
    // el area de salida final
    public JTextArea salida = new JTextArea();

    public CalculadoraSimple() {
        // obtenemos el nombre del jugador
        nombre = JOptionPane.showInputDialog("Introduce tu nombre:");
        // obtener el numero maximo
        NUM_INTENTOS = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero de intentos:"));
        // introducir numeros
        introducirNumeros();
        // sacar los datos por pantalla
        salidaDatos();
    }

  
    public void introducirNumeros() {
        for (int i = 0; i < NUM_INTENTOS; i++) {
           numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero , intento " + (i + 1)));
          acumraizcuadrada = raizcuadrada(numeros[i])+acumraizcuadrada;
            acumcuadrado = cuadrado(numeros[i])+acumcuadrado;
            JOptionPane.showMessageDialog(null, "El numero es: " +numeros[i] + "\n" + 
                    "El cuadrado es: " +cuadrado(numeros[i]) + "\n" + 
                    "La raiz cuadrada es: " +raizcuadrada(numeros[i]) + "\n");
        }
    }

    public double raizcuadrada(int r) {
        return Math.sqrt(r);
    }

    public double cuadrado(int c) {
        return c*c;
   }

    public void salidaDatos() {
        salida.append("Nombre de jugador " + nombre + "\n");
        salida.append("Numero maximo de intentos " + NUM_INTENTOS + "\n");
        salida.append("Suma de raiz cuadrada " +acumraizcuadrada + "\n");
        salida.append("Suma de cuadrado " +acumcuadrado + "\n");
   //     salida.append("Los numeros que han calculado son " + numeros[i] + "\n");
        JOptionPane.showMessageDialog(null, salida, "RESULTADO", JOptionPane.INFORMATION_MESSAGE);
        
        
    }
}
