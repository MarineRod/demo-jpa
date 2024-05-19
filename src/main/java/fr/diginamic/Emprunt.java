package fr.diginamic;


import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "DATE_DEBUT")
	private LocalDate dateDeb;
	@Column(name = "DELAI")
	private int delai;
	@Column(name = "DATE_FIN")
	private LocalDate dateFin;
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;
	@ManyToMany
	@JoinTable(name = "COMPO", joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
	private Set<Livre> livres;

	public Emprunt() {
		super();
	}

	public Emprunt(LocalDate dateDeb, int delai, LocalDate dateFin) {
		super();
		this.dateDeb = dateDeb;
		this.delai = delai;
		this.dateFin = dateFin;
	}

	public Emprunt(LocalDate dateDeb, int delai, LocalDate dateFin, Client client) {
		super();
		this.dateDeb = dateDeb;
		this.delai = delai;
		this.dateFin = dateFin;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(LocalDate dateDeb) {
		this.dateDeb = dateDeb;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDeb=" + dateDeb + ", delai=" + delai + ", dateFin=" + dateFin + ", client="
				+ client + "]";
	}

}