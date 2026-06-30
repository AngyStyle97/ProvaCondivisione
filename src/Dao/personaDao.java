package Dao; 

import entity.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class personaDao { 

    // Ricordati di verificare se la password di pgAdmin coincide!
    private String url = "jdbc:postgresql://localhost:5432/postgres";
    private String utente = "postgres";
    private String passwordDb = "Charmander659"; // <--- METTI LA TUA PASSWORD DI PGADMIN

    public personaDao() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("🔴 Errore: Driver JDBC non trovato nel DAO!");
        }
    }

    public Persona trovaPerEmail(String emailInserita) { 
        // Usiamo TRIM sia sulla colonna del DB che sul parametro per evitare problemi di spazi vuoti
        String sql = "SELECT * FROM persona WHERE TRIM(email) = TRIM(?)";
        
        try {
            Connection conn = DriverManager.getConnection(url, utente, passwordDb);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emailInserita.trim());
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Estraiamo i dati pulendoli da eventuali spazi del tipo char(100)
                String nomeDb = rs.getString("nome").trim();
                String cognomeDb = rs.getString("cognome").trim();
                String emailDb = rs.getString("email").trim();
                String passwordDb = rs.getString("password").trim();
                
                // Creiamo l'oggetto da ritornare al controller
                Persona personaTrovata = new Persona(nomeDb, cognomeDb, emailDb, passwordDb);
                
                rs.close();
                stmt.close();
                conn.close();
                
                return personaTrovata; // Trovata!
            }
            
            // Se arriviamo qui, il ResultSet è vuoto (nessun utente con quella mail)
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("🔴 Errore SQL dentro personaDao!");
            e.printStackTrace();
        }
        
        return null; // Ritorna null se l'email non esiste
    }
}