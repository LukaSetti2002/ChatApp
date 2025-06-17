package chatapp.user;                                       // Namespace per logica utenti

import chatapp.api.ChatParticipant;                           // Import interfaccia
import chatapp.model.Message;                                  // Import classe Message

/**
 * User rappresenta un partecipante standard alla chat
 * e implementa il contratto ChatParticipant.
 */
public class User implements ChatParticipant {
    private String name;                                      // Nome utente

    /**
     * Costruttore con nome utente.
     */
    public User(String name) {
        this.name = name;                                     // Inizializza il campo name
    }

    /** Restituisce il nome utente */
    public String getName() {                                 // Getter name
        return name;
    }

    /**
     * Implementazione di sendMessage: crea un Message
     * e lo stampa in console.
     */
    @Override
    public void sendMessage(String content) {
        Message msg = new Message(name, content);            // Crea Message
        System.out.println(msg);                             // Stampa [name]: content
    }
}