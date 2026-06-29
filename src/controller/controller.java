package controller;
import entity.Persona;
import GUI.Homepage;
import GUI.login;

public class controller {
	
	Persona p1;
	Homepage h1;
    login l1;
    
    public controller() {
    	p1= new Persona("a","b");
    }
	

	
	public  void controllalogin(String email, String password, login l1) {
		p1.email=email;
		p1.password=password;
		if(email.equals(p1.getemail()) && password .equals(p1.getpassword())) {
			l1.dispose();
			h1=new Homepage();
			h1.setVisible(true);
		}
		
		
	}
	
	
		
		
		
	
}
        

