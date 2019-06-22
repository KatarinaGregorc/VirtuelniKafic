package Validacija;

import admin.Admin;

public class ValidacijaZaRegistraciju {
	
	public static boolean proveraPassworda(String password,String repeatPassword){
		
		if(password.equals(repeatPassword)) {
			
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public static boolean daLIJeAdmin(String userName,String password) {
		
		Admin admin=new Admin();
		
		if(userName.equals(admin.getAdminUserName()) && password.equals(admin.getAdminPassword())) {
			
			return true;
			
			
		}else {
			return false;
		}
		
		
	}
	
	

}
