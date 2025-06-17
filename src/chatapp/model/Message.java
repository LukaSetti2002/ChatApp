package chatapp.model; // Package per il modello dati

/**
 * Message rappresenta un messaggio in chat
 * con mittente e contenuto.
 */
public class Message {
    private String sender; // Mittente del messaggio (private)
    private String content; // Contenuto del messaggio (private)

    /** Costruttore per inizializzare mittente e contenuto */
    public Message(String sender, String content) {
        this.sender = sender; // Assegna sender
        this.content = content; // Assegna content
    }

    /** Getter per il mittente */
    public String getSender() { // Restituisce sender
        return sender;
    }

    /** Getter per il contenuto */
    public String getContent() { // Restituisce content
        return content;
    }

    /** toString sovrascritto per stampa leggibile */
    @Override //Annotazione che indica che toString() ridefinisce il metodo ereditato da Object.
    public String toString() { // Rappresentazione testo: [sender]: content
        return "[" + sender + "]: " + content;
    }
}
