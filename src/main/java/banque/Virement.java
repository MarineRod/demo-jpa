package banque;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("Virement")
@Table (name = "VIREMENT")
public class Virement extends Operation {
	
	private String beneficiaire;

	public Virement(String beneficiaire, LocalDateTime date, double montant, String motif, Compte compte) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	@Override
	public String toString() {
		return super.toString() + "Virement [beneficiaire=" + beneficiaire + "]";
	}

	
}
