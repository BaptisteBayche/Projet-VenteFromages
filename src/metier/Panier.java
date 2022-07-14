package metier;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Panier {
	
	private List<Article> articlesPanier;
	private List<Integer> prixPanier;
	private float prixLivraison;
	private float reduction;
	private float prixTotalArticle;

	
	
	public Panier() {
		this.articlesPanier = new ArrayList<>();
		this.prixPanier = new ArrayList<>();
		this.prixLivraison = 0.00f;
		this.reduction = 0.00f;
		this.prixTotalArticle = 0.00f;
	}
	
	public void addArticle(Article article, int quantité) {
		if (quantité > 0 ) {
			boolean estPresent = false;
			int i = 0;
			for (Article a : this.articlesPanier) {
				if(article.getFromage().getDésignation() == a.getFromage().getDésignation() && article.getClé() == a.getClé()) {
					this.prixPanier.set(i, this.prixPanier.get(i) + quantité);
					a.préempterQuantité(quantité);
					estPresent = true;
				}
				i++;
			}
			
			if (!estPresent) {
				this.prixPanier.add(quantité);
				this.articlesPanier.add(article);
				article.préempterQuantité(quantité);
			}
		}
	
	}
	
	public List<Article> getPanier() {
		return this.articlesPanier;
	}
	
	public List<Integer> getQuantité(){
		return this.prixPanier;
	}
	
	public boolean isEmpty() {
		return this.articlesPanier.toArray().length == 0;
	}
	
	public float prixTotal() {
		float prixTotal = 0.0f;
		int i = 0;
		for(Article a : this.articlesPanier) {
			 prixTotal += a.getPrixTTC() * this.prixPanier.get(i);
			 i++;
		}
		this.prixTotalArticle = prixTotal;
		prixTotal += prixLivraison;
		return prixTotal - (prixTotal * (this.reduction/100));
		
	}
	
	public float getPrixTotalArticle() {
		return this.prixTotalArticle;
	}
	
	public void setPrixLivraison(float prix) {
		this.prixLivraison =  prix;
	}
	
	public void setReduction(String code) {
		switch (code) {
		case "IUT-INFO":
			this.reduction = 10;
			break;
		case "S2.01": 
			this.reduction = 15;
			break;
		default: 
			this.reduction = 0;
		}
	}
	
	public String toString() {
		String s  = "";
		int i = 0;
		for (Article a : this.articlesPanier) {
			s += String.format("%20s :  	Quantité : %3s		Prix par unité : %.2f		Prix : %.2f \n", a.toStringPanier(), this.prixPanier.get(i), a.getPrixTTC(), (float) a.getPrixTTC()*this.prixPanier.get(i));
			i++;
		}
		s += String.format("\nPrix Total Articles : %.2f € \n" , this.prixTotalArticle);
		s += String.format("\nRéduction : -%2.0f" , this.reduction) + "%";
		s += String.format("\nPrix de livraison : %.2f €" , this.prixLivraison);
		s += String.format("\nPrix total : %.2f €" , this.prixTotal());
		return s;
	}
	
	public void reinitialisationPanier(){
		int i = 0;
		for (Article a : this.articlesPanier) {
			a.rendreQuantité(this.prixPanier.get(i));
		}
		this.reinitialisationValeur();
	}
	
	public void reinitialisationValeur() {
		this.articlesPanier.clear();
		this.prixPanier.clear();
		this.reduction = 0.00f;	
		this.prixTotalArticle = 0.00f;
	}
	
	
	
	

}
