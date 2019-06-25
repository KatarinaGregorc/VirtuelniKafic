package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.User;

public class logInDao {
	
	
   private  SessionFactory sf=new Configuration().configure().buildSessionFactory();
   
   public boolean daLiPostojiUserUbazi(String userName) {
	   
		Session sessio=sf.openSession();
		sessio.beginTransaction();
		
		try {
			String upit="FROM User where userName = :korisnickoIme";
			Query query = sessio.createQuery(upit);
			
            query.setParameter("korisnickoIme",userName );
            
            List<User>ListaUsera=query.getResultList();
            
            if(ListaUsera.isEmpty()) {
            	sessio.getTransaction().commit();sessio.getTransaction().commit();
            	System.out.println("Ne postoji user");
            	return false;
            }else {
            	
            	System.out.println("Dobar je usrName");
            	return true;
            }
            
		} catch (Exception e) {
		  sessio.getTransaction().rollback();
		  System.out.println("Nije dobar");
		  return false;
		}finally {
			
			sessio.close();
		}  
	   
	   
   }
    

   public boolean daLiPasswordOdgovaraUser(String userName,String password) {
	   
	   Session sessio=sf.openSession();
		sessio.beginTransaction();
		boolean vrati=false;
		try {
			String upit="FROM User where userName = :korisnickoIme";
			Query query = sessio.createQuery(upit);
			
           query.setParameter("korisnickoIme",userName );
           
           List<User>ListaUsera=query.getResultList();
           
           for (User userIzBaze : ListaUsera) {
			if(userIzBaze.getPassword().equals(password)) {
				System.out.println("Pustaj");
			sessio.getTransaction().commit();
			return true;
			
			}else{
			System.out.println("ne");
			sessio.getTransaction().commit();
			}  
		
		
           }} catch (Exception e) {
		  sessio.getTransaction().rollback();
		  System.out.println("Nije dobar");
		  return false;
		}finally {
			
			sessio.close();   
	   
		}
		return vrati;
		}
   
   public User vratiUsera(String userName) {
	   
	   User user=new User();
	   
	   Session session=sf.openSession();
	    
	    try {
	 		String upit="FROM User where userName = :korisnickoIme";
	 		Query query = session.createQuery(upit);
	 		
	       query.setParameter("korisnickoIme",userName );
	       
	       List<User>ListaUsera=query.getResultList();
	       user=ListaUsera.get(0);
	       
	       return  user;
	 		
	 	
	       
	    } catch (Exception e) {
	 	  session.getTransaction().rollback();
	 	 
	 	  return null;
	 	}finally {
	 		
	 		session.close();   
	   
	 	}
	 	
	    
	   
   }
   
 

	

   }


	   
	   
	   
	   
	   
	   
	   
   
		
   

   
   
		
