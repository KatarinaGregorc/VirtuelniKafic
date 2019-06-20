package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class RegistracijaDao {

	private  SessionFactory sf=new Configuration().configure().buildSessionFactory();
    
	
	
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public boolean upisiUseraUBazu(String usrName,String password) {
		
		User user=new User();
		user.setUserName(usrName);
		user.setPassword(password);
		
		Session sessio=sf.openSession();
		sessio.beginTransaction();
		
		try {
			sessio.save(user);
			sessio.getTransaction().commit();
			System.out.println("Uspesno ubacen user");
			return true;
		} catch (Exception e) {
		  sessio.getTransaction().rollback();
		  System.out.println("Nije ubacen user");
		  return false;
		}finally {
			
			sessio.close();
		}
	}
	
}
