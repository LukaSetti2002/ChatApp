package chatapp.client;                    // Package client

import java.io.*;                          // Import I/O da console e socket
import java.net.Socket;                    // Import Socket

public class ClientApp {
    public static void main(String[] args) {
        try (
            Socket socket = new Socket("localhost", 12345);                // Connessione al server
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in)); // Lettura da tastiera
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Invio dati al server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Ricezione risposta
        ) {
            System.out.println("Connesso al server. Digita un messaggio:"); // Prompt utente
            String input;
            while ((input = console.readLine()) != null) {                   // Loop lettura da console
                out.println(input);                                          // Invia al server
                String response = in.readLine();                             // Legge la risposta
                System.out.println(response);                               // Stampa risposta
            }
        } catch (IOException e) {
            System.err.println("Errore client: " + e.getMessage()); // Gestione errore connessione
        }
    }
}