package chatapp.server; // Package server

import chatapp.db.DBManager; // Import DBManager
import chatapp.user.*; // Import User e Admin
import java.io.*; // Import I/O
import java.net.Socket; // Import Socket

public class ClientHandler implements Runnable {
    private Socket socket; // Socket per il client
    private DBManager dbManager; // Riferimento al DBManager

    public ClientHandler(Socket socket, DBManager dbManager) {
        this.socket = socket; // Assegna socket
        this.dbManager = dbManager; // Assegna dbManager
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Lettura da client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true) // Scrittura con auto-flush
        ) {
            String line;
            while ((line = in.readLine()) != null) {  // Loop finché arrivano dati
                User user;
                if (line.startsWith("/admin ")) {  // Se inizia con /admin
                    user = new Admin("Admin");
                    line = line.substring(7); // Rimuove prefisso
                } else {
                    user = new User("User");  // Altrimenti usa User
                }
                user.sendMessage(line); // Stampa messaggio
                dbManager.insertMessage(user.getName(), line); // Salva su DB
                out.println("Messaggio ricevuto: " + line);   // Risponde al client
            }
        } catch (IOException e) {
            System.err.println("Errore client: " + e.getMessage()); // Gestione I/O error
        }
    }
}
