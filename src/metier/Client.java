package metier;

public class Client {
	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String ville;
	private String rue;
	private String codePostal;	
	
	public Client(String nom, String prenom, String telephone, String email, String ville, String rue, String codePostal) {
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.ville = ville;
		this.rue = rue;
		this.codePostal = codePostal;
	}
	
	public Boolean verificationChamps() {
		if (this.nom.equals(" ")) {
			return false;
		}
		if (this.prenom.equals(" ")) {
			return false;
		}
		if (this.telephone.equals(" ")) {
			this.telephone = "Non renseigné";	
		}
		if (this.email.equals(" ")) {
			return false;
		}
		if (this.ville.equals(" ")) {
			return false;
		}
		if (this.rue.equals(" ")) {
			return false;
		}
		if (this.codePostal.equals(" ")){
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return " ====  INFORMATION CLIENT ====\n" +
				"\n 	Nom              : " + nom + 
				"\n 	Prenom         : " + prenom + 
				"\n 	Telephone     : " + telephone + 
				"\n 	Email             : " + email +
				"\n 	Ville                : " + ville + 
				"\n 	Rue                : " + rue + 
				"\n 	Code Postal   : " + codePostal;
	}
	
	

}
