package entity;

public class Persona {
      private String name;
      private String surname;
      
      public Persona(String name, String surname) {
    	  this.name = name;
    	  this.surname = surname;
    	  
    	  
    	  
    	   
      }
      

      public String getName() {
    	  return name;
      }
      
      public void print() {
    	  System.out.println("Buonasera");
      }

      
       public void hello() {
    	   System.out.println("   buongiorno  "+"  io sono   "  +   name);
       }

}
