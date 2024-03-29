package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Racun {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idRacun;
	@ManyToOne
	private User user;
	private Date date=new Date();
	@OneToMany
	private List<Artikal>ListaArtikla=new ArrayList<Artikal>();
	public long getIdRacun() {
		return idRacun;
	}
	public void setIdRacun(long idRacun) {
		this.idRacun = idRacun;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Artikal> getListaArtikla() {
		return ListaArtikla;
	}
	public void setListaArtikla(List<Artikal> listaArtikla) {
		ListaArtikla = listaArtikla;
	}
	

}
