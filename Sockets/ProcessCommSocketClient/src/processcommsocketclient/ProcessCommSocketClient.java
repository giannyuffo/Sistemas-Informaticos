/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processcommsocketclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Alex
 */
public class ProcessCommSocketClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        System.out.println("Por favor, introduzca el mensaje: ");
        BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 9000);

        try (DataOutputStream salida = new DataOutputStream(clientSocket.getOutputStream());
                BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String mensaje = entradaUsuario.readLine();

            salida.writeBytes(mensaje + "\n");

            String respuesta = entrada.readLine();

            System.out.println("Respuesta del servidor: " + respuesta);
        }
        
        clientSocket.close();
    }

}
