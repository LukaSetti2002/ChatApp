package chatapp.config;                     // Definisce il namespace: il file si trova in src/chatapp/config/

import javax.xml.parsers.*;                // Import per il parser DOM di Java
import org.w3c.dom.*;                       // Import per gli elementi DOM (Document, Element)
import java.io.File;                        // Import per rappresentare file sul filesystem

/**                                        // Inizio Javadoc: documentazione della classe
 * La classe Config legge il file config.xml e fornisce
 * metodi di accesso ai parametri di configurazione.
 */
public class Config {
    private int port;                       // Campo privato: porta su cui ascolterà il server
    private String dbUrl;                   // Campo privato: URL JDBC per il database

    /**                                    // Javadoc per il costruttore
     * Costruttore: carica e analizza il file XML.
     * @param filename percorso del file config.xml
     * @throws Exception in caso di errore di I/O o parsing
     */
    public Config(String filename) throws Exception {
        // Creazione del factory per il parser DOM
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Creazione del builder a partire dal factory
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parsing del file XML in un oggetto Document
        Document doc = builder.parse(new File(filename));
        // Ottenimento del nodo radice <config>
        Element root = doc.getDocumentElement();

        // Estrazione del testo contenuto nel tag <port>
        String portStr = root.getElementsByTagName("port").item(0).getTextContent();
        // Conversione da String a int
        this.port = Integer.parseInt(portStr);

        // Estrazione del testo contenuto nel tag <url>
        this.dbUrl = root.getElementsByTagName("url").item(0).getTextContent();
    }

    /** Restituisce la porta configurata */
    public int getPort() {                   // Getter pubblico per la porta
        return port;
    }

    /** Restituisce l'URL del database */
    public String getDbUrl() {              // Getter pubblico per l'URL JDBC
        return dbUrl;
    }
}
