package chatapp.db;                        // Package per la gestione del DB

import java.sql.*;                        // Import JDBC: Connection, DriverManager, SQLException

/**                                        // Javadoc: descrive la responsabilità della classe
 * DBManager gestisce la connessione e le operazioni
 * sul database SQLite.
 */
public class DBManager {
    private Connection connection;          // Connessione JDBC aperta verso SQLite

    /** Costruttore: apre connessione e crea la tabella messages */
    public DBManager(String dbUrl) throws Exception {
        // Caricamento forzato del driver org.sqlite.JDBC
        Class.forName("org.sqlite.JDBC");
        // Apertura della connessione al database
        this.connection = DriverManager.getConnection(dbUrl);

        // Creazione tabella se non esiste
        String sql = "CREATE TABLE IF NOT EXISTS messages (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "sender TEXT NOT NULL," +
                     "content TEXT NOT NULL," +
                     "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP" +
                     ");";
        try (Statement stmt = connection.createStatement()) {
            // Esecuzione DDL per creare la tabella
            stmt.execute(sql);
        }
    }

    /** Inserisce un nuovo messaggio nella tabella */
    public void insertMessage(String sender, String content) {
        String sql = "INSERT INTO messages (sender, content) VALUES (?, ?)";  // SQL parametrizzato
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sender);      // Sostituisce il primo ?: sender
            pstmt.setString(2, content);     // Sostituisce il secondo ?: content
            pstmt.executeUpdate();           // Esegue l'inserimento
        } catch (SQLException e) {
            // Gestione errore: stampa su stderr
            System.err.println("Errore inserimento messaggio: " + e.getMessage());
        }
    }
}