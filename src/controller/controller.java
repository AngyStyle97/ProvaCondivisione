package controller;

import entity.Persona;
import GUI.Homepage;
import GUI.login;

public class controller {
	
    Persona p1;
    Homepage h1;
    login l1;
    
    // Nel costruttore creiamo la persona con le credenziali "a" e "b"
    public controller() {
        p1 = new Persona(  "marco" , "polo" ,"a", "b");
    }
	
    public void controllalogin(String email, String password, login l1) {
        try {
            // Il try controlla se i dati inseriti corrispondono a p1
            if (email.equals(p1.getemail().trim()) && password.equals(p1.getpassword().trim())) {
                
                // Se sono corretti, aggiorna i dati di p1
                p1.email = email;
                p1.password = password;
                
                l1.dispose();
                h1 = new Homepage();
                h1.setVisible(true);
                System.out.println("Login effettuato con successo!");
            } else {
                System.out.println("Credenziali errate! Accesso negato.");
            }
            
        } catch (NullPointerException e) {
            System.out.println("--- ERRORE RILEVATO: Uno dei campi è null o vuoto ---");
            // Questo comando stampa in rosso la riga esatta dell'errore nella console
            e.printStackTrace(); 
        }
    }
}