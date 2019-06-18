package Validacija;

public class ValidacijaZaRegistraciju {
	
	public static boolean proveraPassworda(String password,String repeatPassword){
		
		if(password.equals(repeatPassword)) {
			
			return true;
		}else {
			return false;
		}
		
		
	}
	
	

}
