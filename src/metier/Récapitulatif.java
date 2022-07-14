package metier;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Récapitulatif {

		private Client client;
		private Panier panier;
		
		public Récapitulatif(Client client, Panier panier) {
			this.client = client;
			this.panier = panier;
		}
		
		public String toString() {
			String s = "		 ==== > Boutique From Age < === \n\n"
			+ "Facture fait à Toulouse le " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd / MM / YYYY")) + " à " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))  + "\n\n"
			+ this.client.toString() + "\n\n\n ====  VOS ARTICLES ====\n\n" + this.panier.toString() + 
			"\n\n\nMerci pour votre commade sur From Age";
			return s;
			
			
		}
		
}
