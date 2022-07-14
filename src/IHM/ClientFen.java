package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Client;
import metier.Panier;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import java.awt.Font;

public class ClientFen extends JDialog {
	private JTextField textFieldPrenom;
	private JTextField textFieldEmail;
	private JTextField textFieldRue;
	private JTextField textFieldCodePostal;
	private Client client;
	private Panier panier;
	private JTextField textFieldNom;
	private JTextField textFieldTelephone;
	private JComboBox comboVille;
	private JLabel lblChampsAVerifie;
	private Menu menu;
	private PanierFen panierFen;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ClientFen(Panier panier, Menu menu, PanierFen panierFen) {
		setBounds(100, 100, 531, 388);
		this.panier = panier;
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
				panel_1.add(verticalStrut);
			}
		}
	}

	private void initialize_ZoneTiter_South() {
		JPanel zone_Button_South = new JPanel();
		getContentPane().add(zone_Button_South, BorderLayout.SOUTH);
		zone_Button_South.setLayout(new BoxLayout(zone_Button_South, BoxLayout.Y_AXIS));
		{
			JPanel panelBouton = new JPanel();
			zone_Button_South.add(panelBouton);
			panelBouton.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btn_Annuler = new JButton("Quitter");
				btn_Annuler.setFont(new Font("Roboto", Font.PLAIN, 12));
				constructeurBoutonQuitter(btn_Annuler);
				panelBouton.add(btn_Annuler);
			}
			{
				JButton btn_Sauvegarder = new JButton("Imprimer");
				btn_Sauvegarder.setFont(new Font("Roboto", Font.PLAIN, 12));
				constructeurBoutonImprimer(btn_Sauvegarder, this.menu, this.panierFen, this );
				panelBouton.add(btn_Sauvegarder);
			}
		}
		{
			JPanel panelTexte = new JPanel();
			zone_Button_South.add(panelTexte);
			{
				lblChampsAVerifie = new JLabel("*  Champs obligatoire");
				lblChampsAVerifie.setFont(new Font("Roboto", Font.PLAIN, 12));
				lblChampsAVerifie.setVisible(false);
				panelTexte.add(lblChampsAVerifie);
			}
		}
	}




	private void initialize_ZoneTiter_Center() {
		JPanel zone_Center = new JPanel();
		getContentPane().add(zone_Center, BorderLayout.CENTER);
		zone_Center.setLayout(new GridLayout(2, 1, 0, 0));
		{
			JPanel zone_Info_client = new JPanel();
			zone_Center.add(zone_Info_client);
			zone_Info_client.setLayout(new GridLayout(2, 1, 0, 0));
			{
				JLabel lbl_Infoclient = new JLabel("         Information Client");
				lbl_Infoclient.setFont(new Font("Roboto", Font.BOLD, 15));
				zone_Info_client.add(lbl_Infoclient);
			}
			{
				JPanel zone_Client_saisi = new JPanel();
				zone_Info_client.add(zone_Client_saisi);
				zone_Client_saisi.setLayout(new GridLayout(0, 4, 5, 5));
				{
					JLabel lbl_client_nom = new JLabel("* Nom :");
					lbl_client_nom.setFont(new Font("Roboto", Font.PLAIN, 12));
					lbl_client_nom.setHorizontalAlignment(SwingConstants.RIGHT);
					zone_Client_saisi.add(lbl_client_nom);
				}
				{
					textFieldNom = new JTextField();
					textFieldNom.setFont(new Font("Roboto", Font.PLAIN, 12));
					textFieldNom.setText(" ");
					textFieldNom.setColumns(10);
					zone_Client_saisi.add(textFieldNom);
				}
				{
					JLabel lbl_client_prenom = new JLabel("* Prenom :");
					lbl_client_prenom.setFont(new Font("Roboto", Font.PLAIN, 12));
					lbl_client_prenom.setHorizontalAlignment(SwingConstants.RIGHT);
					zone_Client_saisi.add(lbl_client_prenom);
				}
				{
					textFieldPrenom = new JTextField();
					textFieldPrenom.setFont(new Font("Roboto", Font.PLAIN, 12));
					textFieldPrenom.setText(" ");
					textFieldPrenom.setColumns(10);
					zone_Client_saisi.add(textFieldPrenom);
				}
				{
					JLabel lbl_info_tel = new JLabel("Telephone :");
					lbl_info_tel.setFont(new Font("Roboto", Font.PLAIN, 12));
					lbl_info_tel.setHorizontalAlignment(SwingConstants.RIGHT);
					zone_Client_saisi.add(lbl_info_tel);
				}
				{
					textFieldTelephone = new JTextField();
					textFieldTelephone.setFont(new Font("Roboto", Font.PLAIN, 12));
					textFieldTelephone.setText(" ");
					textFieldTelephone.setColumns(10);
					zone_Client_saisi.add(textFieldTelephone);
				}
				{
					JLabel lbl_info_mail = new JLabel("* Email :");
					lbl_info_mail.setFont(new Font("Roboto", Font.PLAIN, 12));
					lbl_info_mail.setHorizontalAlignment(SwingConstants.RIGHT);
					zone_Client_saisi.add(lbl_info_mail);
				}
				{
					textFieldEmail = new JTextField();
					textFieldEmail.setFont(new Font("Roboto", Font.PLAIN, 12));
					textFieldEmail.setText(" ");
					textFieldEmail.setColumns(10);
					zone_Client_saisi.add(textFieldEmail);
				}
			}
		}
		{
			JPanel zone_info_livraison = new JPanel();
			zone_Center.add(zone_info_livraison);
			zone_info_livraison.setLayout(new GridLayout(2, 1, 0, 0));
			{
				JLabel lbl_Infolivraison = new JLabel("         Information de livraison");
				lbl_Infolivraison.setFont(new Font("Roboto", Font.BOLD, 15));
				zone_info_livraison.add(lbl_Infolivraison);
			}
			{
				JPanel zone_Livraison_saisi = new JPanel();
				zone_info_livraison.add(zone_Livraison_saisi);
				zone_Livraison_saisi.setLayout(new GridLayout(0, 4, 5, 5));
				{
					JLabel lbl_livraison_ville = new JLabel("* Ville :");
					lbl_livraison_ville.setFont(new Font("Roboto", Font.PLAIN, 12));
					lbl_livraison_ville.setHorizontalAlignment(SwingConstants.RIGHT);
					zone_Livraison_saisi.add(lbl_livraison_ville);
				}
				{
					comboVille = new JComboBox();
					comboVille.setFont(new Font("Roboto", Font.PLAIN, 12));
					comboVille.setModel(new DefaultComboBoxModel(new String[] {"Toulouse", "Paris", "Montpellier", "Lyon", "Marseille", "Nice", "Dijon", "Troyes", "Rennes", "Brest", "Nantes", "Bordeaux", "Strasbourg", "Lille", "Reims", "Toulon", "Saint-Etienne", "Le Havre", "Grenoble", "Angers", "N\u00EEmes", "Le Mans", "Aix-en-Provence", "Perpignan", "Orl\u00E9ans", "Rouen", "Caen", "Nancy", "TourCoing", "Avignon", "Poitiers", "B\u00E9ziers", "Pamiers", "La Rochelle", "Versailles", "Cannes", "Quimper", "Montauban", "Narbonne", "Saint-Andr\u00E9", "Albi", "Carcassonne"}));
					comboVille.setSelectedIndex(0);
					zone_Livraison_saisi.add(comboVille);
				}
				{
					JLabel lbl_livraison_rue = new JLabel("* Rue :");
					lbl_livraison_rue.setFont(new Font("Roboto", Font.PLAIN, 12));
					lbl_livraison_rue.setHorizontalAlignment(SwingConstants.RIGHT);
					zone_Livraison_saisi.add(lbl_livraison_rue);
				}
				{
					textFieldRue = new JTextField();
					textFieldRue.setFont(new Font("Roboto", Font.PLAIN, 12));
					textFieldRue.setText(" ");
					textFieldRue.setColumns(10);
					zone_Livraison_saisi.add(textFieldRue);
				}
				{
					JLabel lbl_livraison_code_postal = new JLabel("* Code Postal :");
					lbl_livraison_code_postal.setFont(new Font("Roboto", Font.PLAIN, 12));
					lbl_livraison_code_postal.setHorizontalAlignment(SwingConstants.RIGHT);
					zone_Livraison_saisi.add(lbl_livraison_code_postal);
				}
				{
					textFieldCodePostal = new JTextField();
					textFieldCodePostal.setFont(new Font("Roboto", Font.PLAIN, 12));
					textFieldCodePostal.setText(" ");
					textFieldCodePostal.setColumns(10);
					zone_Livraison_saisi.add(textFieldCodePostal);
				}
			}
		}
		
	}
	
	private void constructeurBoutonQuitter(JButton btn_Annuler) {
		btn_Annuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
	}
	
	private void constructeurBoutonImprimer(JButton btn_Sauvegarder, Menu menu, PanierFen panierFen, ClientFen clientFen) {
		btn_Sauvegarder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				client = new Client(textFieldNom.getText(), textFieldPrenom.getText(), textFieldTelephone.getText(), textFieldEmail.getText(), comboVille.getSelectedItem().toString(),textFieldRue.getText(),textFieldCodePostal.getText());
				if (!client.verificationChamps()){
					lblChampsAVerifie.setVisible(true);
				}else {
					FactureFen fenetreFacture = new FactureFen(client, panier, menu, panierFen, clientFen );
					fenetreFacture.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					fenetreFacture.setVisible(true);
				}

			}
		});
		
		
	
	}

}
