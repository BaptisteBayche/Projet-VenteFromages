package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import metier.Article;
import metier.Articles;
import metier.Fromage;
import metier.GenerationFromages;
import metier.Panier;
import metier.TypeLait;

public class TestApplication {
	
	private Articles mesArticles;
	private Panier panier;
	private Fromage[] fromages;
	private Article a1;
	
	@Before 
	public void setUp() {
		this.panier = new Panier();
		this.mesArticles = GenerationFromages.générationBaseFromages();
		this.fromages = mesArticles.getLesFromages();
		this.a1 = new Article(fromages[1], "500 g", 16.4f);
	}
	
	@After
	public void tearDown() {
		this.panier = null;
		this.mesArticles = null;
		this.fromages = null;
		this.a1 = null;
	}
	
	@Test
	public void TestFiltre () {
	
		for (Fromage f : this.mesArticles.fromageAuLaitDe(TypeLait.VACHE)) {
			assertEquals(f.getTypeFromage(), TypeLait.VACHE);
		}
		
		for (Fromage f : this.mesArticles.fromageAuLaitDe(TypeLait.BREBIS)) {
			assertEquals(f.getTypeFromage(), TypeLait.BREBIS);
		}
		
		for (Fromage f : this.mesArticles.fromageAuLaitDe(TypeLait.CHEVRE)) {
			assertEquals(f.getTypeFromage(), TypeLait.CHEVRE);
		}
	}
	
	@Test
	public void TestArticle () {
		assertEquals(a1.getFromage().getArticles().toString(), "[Brebis au Fenugrec, 250 g, Prix TTC : 8.2 €, Brebis au Fenugrec, 500 g, Prix TTC : 16.4 €, Brebis au Fenugrec, 1 kg, Prix TTC : 32.8 €]");
	}
	
	@Test
	public void TestPanier () {

		this.panier.addArticle(this.a1, 2);
		//Test ajout 1 article 
		assertEquals(this.panier.getPanier().get(0), this.a1 );
		this.panier.addArticle(this.a1, 3);
		// Ajout quantité au premier article
		// Vérification de si il y a toujours 1 article dans le panier
		assertEquals(this.panier.getPanier().toArray().length, 1 );
		// Vérification de la modification de la quantité 
		assertEquals(this.panier.getQuantité().get(0), 5, 0.1f );
		this.panier.reinitialisationPanier();
		//Test suppression panier 
		assertEquals(this.panier.getPanier(), new Panier().getPanier());
		
		
	
	}
	
	@Test
	public void TestFacture () {
		this.panier.addArticle(this.a1, 5);
		this.panier.prixTotal();
		//Test prix des articles
		assertEquals(this.panier.getPrixTotalArticle(), 82.00f ,0.00f);
		panier.setPrixLivraison(1.50f);
		//Test avec prix de livraison
		assertEquals(this.panier.prixTotal(), 83.50f,0.00f);
		panier.setReduction("IUT-INFO");
		//Test avec reduction
		assertEquals(this.panier.prixTotal(), 75.15f, 0.00f);
		this.panier.reinitialisationPanier();
		//Test avec la suppression du panier 
		assertEquals(this.panier.getPrixTotalArticle(), 0.00f, 0.00f);
		
		
	}
	
	@Test
	public void TestStock () {
		this.a1.setQuantitéEnStock(50);
		this.panier.addArticle(this.a1, 5);
		// Test achat produit 
		assertEquals(this.a1.getQuantitéEnStock(), 45);
		this.panier.addArticle(this.a1, 10);
		// Test achat meme produit 
		assertEquals(this.a1.getQuantitéEnStock(), 35);
		this.panier.reinitialisationPanier();
		//Test apres avoir vider le panier
		assertEquals(this.a1.getQuantitéEnStock(),50);
		
	}
}