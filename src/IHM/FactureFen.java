package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Client;
import metier.Panier;
import metier.Récapitulatif;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class FactureFen extends JDialog {

	private Client client;
	private Panier panier;
	private Récapitulatif recap;
	private PanierFen panierFen;
	private Menu menu;
	private ClientFen clientFen;
	public FactureFen(Client client, Panier panier, Menu menu, PanierFen panierFen, ClientFen clientFen) {
		setBounds(100, 100, 748, 509);
		this.client = client;
		this.panier = panier;
		this.recap = new Récapitulatif(client, panier);
		this.clientFen = clientFen;
		this.menu = menu;
		this.panierFen = panierFen;
		getContentPane().setLayout(new BorderLayout());
		{
			initialize_ZoneTiter_North();
		}
		{
			initialize_ZoneTiter_South();
		}
		{
			initialize_ZoneTiter_Center();
		}
		
		
	}



	private void initialize_ZoneTiter_Center() {
		JPanel zone_facture_center = new JPanel();
		getContentPane().add(zone_facture_center, BorderLayout.CENTER);
		zone_facture_center.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			zone_facture_center.add(scrollPane, BorderLayout.CENTER);
			{
				JTextPane textFacture = new JTextPane();
				textFacture.setFont(new Font("Roboto", Font.PLAIN, 12));
				textFacture.setText(this.recap.toString());
				scrollPane.setViewportView(textFacture);
			}
		}
	}

	private void initialize_ZoneTiter_South() {
		JPanel zone_Button_South = new JPanel();
		getContentPane().add(zone_Button_South, BorderLayout.SOUTH);
		zone_Button_South.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		{
			JButton btn_Annuler = new JButton("Quitter");
			constructeurBoutonQuitter(btn_Annuler, menu , panierFen, clientFen);
			zone_Button_South.add(btn_Annuler);
		}
	}


	private void initialize_ZoneTiter_North() {
		JPanel zone_Titre_North = new JPanel();
		getContentPane().add(zone_Titre_North, BorderLayout.NORTH);
		zone_Titre_North.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			zone_Titre_North.add(panel, BorderLayout.NORTH);
			{
				JLabel lbl_Titre_fromage = new JLabel("From");
				lbl_Titre_fromage.setFont(new Font("Roboto", Font.BOLD, 20));
				panel.add(lbl_Titre_fromage);
			}
			{
				JLabel lbl_Img_fromage = new JLabel("");
				panel.add(lbl_Img_fromage);
				String NomImageTiterPager = "ImageFromageTiter";
				lbl_Img_fromage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImageTiterPager+".png").getPath()));
			}
			{
				JLabel lbl_Titre_magasin = new JLabel("Age");
				lbl_Titre_magasin.setFont(new Font("Roboto", Font.BOLD, 20));
				panel.add(lbl_Titre_magasin);
			}
		}
		{
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.BLACK);
			zone_Titre_North.add(panel_1, BorderLayout.SOUTH);
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			{
				Component verticalStrut = Box.createVerticalStrut(1);
				verticalStrut.setBackground(Color.BLACK);
				panel_1.add(verticalStrut);
			}
		}
	}
		
		private void constructeurBoutonQuitter(JButton btn_Annuler, Menu menu, PanierFen panierFen, ClientFen clientFen) {
			btn_Annuler.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					panier.reinitialisationValeur();
					panierFen.dispose();
					clientFen.dispose();
					menu.setPrixPanier();
					
					dispose();
					
				}
			});
	}
	
	

}
