package chatapp.api;                                          // Specifica il namespace: src/chatapp/api/

/**
 * ChatParticipant definisce il contratto per tutti i partecipanti
 * alla chat: qualsiasi classe che la implementa deve fornire
 * un metodo per inviare messaggi.
 */
public interface ChatParticipant {
    /**
     * Invia un messaggio con il contenuto specificato.
     * @param content testo del messaggio da inviare
     */
    void sendMessage(String content);
}