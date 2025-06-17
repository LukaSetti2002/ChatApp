package chatapp.server; // Package server

import chatapp.config.Config; // Import Config
import chatapp.db.DBManager; // Import DBManager
import java.net.*; // Import per ServerSocket e Socket

public class Server {
    public static void main(String[] args) {
        try {
            Config config = new Config("config.xml");  // Carica configurazione
            DBManager dbManager = new DBManager(config.getDbUrl()); // Inizializza DB

            ServerSocket serverSocket = new ServerSocket(config.getPort()); // Apre socket
            System.out.println("Server avviato sulla porta " + config.getPort());

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Attende connessione
                System.out.println("Nuovo client: " + clientSocket.getInetAddress());
                // Lancia thread per gestire il client
                new Thread(new ClientHandler(clientSocket, dbManager)).start();
            }
        } catch (Exception e) {
            System.err.println("Errore avvio server: " + e.getMessage()); // Gestione errore
        }
    }
}
