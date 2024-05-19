package banque;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("LivretA")
@Table (name = "LIVRETA")
public class LivretA extends Compte {

	private double taux;

	public LivretA() {
		super();
	}

	public LivretA(double taux) {
		super();
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
