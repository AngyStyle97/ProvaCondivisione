package controller;

import entity.Persona;
import GUI.Homepage;
import GUI.login;
import Dao.personaDao; // Importazione corretta del DAO

public class controller {
	
    // Contenitore per l'utente attualmente loggato
    Persona p1; 
    Homepage h1;
    login l1;
    
    // Dichiarazione della variabile del DAO con la D maiuscola
    personaDao personaDao; 
	
    public controller() {
        // Inizializzazione corretta del DAO
        personaDao = new personaDao();
        // Il controller parte pulito, senza istanziare "marco polo" inutilmente!
    }
	
    public void controllalogin(String email, String password, login l1) {
        try {
            // Chiediamo al DAO di cercare l'utente tramite l'email inserita
            Persona utenteTrovato = personaDao.trovaPerEmail(email);  
            
            // Se l'utente esiste nel database
            if (utenteTrovato != null) {
                // Confrontiamo la password inserita nella GUI con quella del DB
                if (password.trim().equals(utenteTrovato.getpassword().trim())) { 
                    
                    // Solo ora p1 prende vita con i dati REALI del database!
                    p1 = utenteTrovato; 
                    
                    // Chiudiamo la schermata di login e apriamo la Homepage
                    l1.dispose();
                    h1 = new Homepage();
                    h1.setVisible(true);
                    System.out.println("🟢 Login effettuato con successo tramite l'architettura DAO!");
                    
                } else {
                    System.out.println("❌ Password errata!");
                }
            } else {
                System.out.println("❌ Questa email non esiste nel Database!");
            }
            
        } catch (NullPointerException e) {
            System.out.println("--- ERRORE RILEVATO: Uno dei campi è null o vuoto ---");
            e.printStackTrace(); 
        }
    }
}