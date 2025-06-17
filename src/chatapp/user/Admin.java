package chatapp.user;                                       // Namespace per logica utenti

import chatapp.api.ChatParticipant;                           // Import interfaccia
import chatapp.model.Message;                                  // Import classe Message

/**
 * Admin è un User speciale che antepone [ADMIN]
 * a ogni messaggio inviato.
 */
public class Admin extends User implements ChatParticipant {
    /**
     * Costruttore: richiama il costruttore di User
     */
    public Admin(String name) {
        super(name);                                         // Inizializza il nome usando super
    }

    /**
     * Override di sendMessage per aggiungere il tag
     * [ADMIN] davanti al contenuto.
     */
    @Override
    public void sendMessage(String content) {
        Message msg = new Message(getName(), "[ADMIN] " + content);
        System.out.println(msg);
    }
}