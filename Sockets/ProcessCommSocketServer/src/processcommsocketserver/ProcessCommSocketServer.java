/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processcommsocketserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alex
 */
public class ProcessCommSocketServer {

    public static void main(String argv[]) throws Exception {
        String mensaje = null;
        ServerSocket socket = new ServerSocket(9000);

        System.out.println("Esperando conexión...");
        while (true) {
            Socket connectionSocket = socket.accept();

            try (BufferedReader entrada
                    = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    DataOutputStream salida = new DataOutputStream(connectionSocket.getOutputStream())) {

                mensaje = entrada.readLine();

                if (mensaje != null) {
                    System.out.println("Mensaje recibido: " + mensaje);

                    salida.writeBytes(mensaje.toUpperCase() + "\n");
                }
            }
        }
    }
}
