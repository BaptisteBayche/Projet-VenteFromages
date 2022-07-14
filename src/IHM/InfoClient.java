package IHM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;

public class InfoClient {

	private JFrame fen_info_client;
	private JTextField tField_client_nom;
	private JTextField tField_client_prenom;
	private JTextField tField_client_tel;
	private JTextField tField_client_mail;
	private JTextField tField_livraison_rue;
	private JTextField tField_livraison_codepostal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoClient window = new InfoClient();
					window.fen_info_client.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InfoClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fen_info_client = new JFrame();
		fen_info_client.setBounds(100, 100, 533, 381);
		fen_info_client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initialize_ZoneTiter_North();
		
		initialize_ZoneButton_South();
		
		initialize_ZoneInformation_Center();
	}

	private void initialize_ZoneInformation_Center() {
		JPanel zone_Center = new JPanel();
		fen_info_client.getContentPane().add(zone_Center, BorderLayout.CENTER);
		zone_Center.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel zone_Info_client = new JPanel();
		zone_Center.add(zone_Info_client);
		
		JLabel lbl_Infoclient = new JLabel("         Information Client");
		
		JPanel zone_Client_saisi = new JPanel();
		zone_Client_saisi.setLayout(new GridLayout(0, 4, 5, 5));
		
		JLabel lbl_client_nom = new JLabel("Nom :");
		lbl_client_nom.setHorizontalAlignment(SwingConstants.RIGHT);
		zone_Client_saisi.add(lbl_client_nom);
		
		tField_client_nom = new JTextField();
		zone_Client_saisi.add(tField_client_nom);
		tField_client_nom.setColumns(10);
		
		JLabel lbl_client_prenom = new JLabel("Prenom :");
		lbl_client_prenom.setHorizontalAlignment(SwingConstants.RIGHT);
		zone_Client_saisi.add(lbl_client_prenom);
		
		tField_client_prenom = new JTextField();
		zone_Client_saisi.add(tField_client_prenom);
		tField_client_prenom.setColumns(10);
		
		JLabel lbl_info_tel = new JLabel("Telephone :");
		lbl_info_tel.setHorizontalAlignment(SwingConstants.RIGHT);
		zone_Client_saisi.add(lbl_info_tel);
		
		tField_client_tel = new JTextField();
		zone_Client_saisi.add(tField_client_tel);
		tField_client_tel.setColumns(10);
		
		JLabel lbl_info_mail = new JLabel("Email :");
		lbl_info_mail.setHorizontalAlignment(SwingConstants.RIGHT);
		zone_Client_saisi.add(lbl_info_mail);
		
		tField_client_mail = new JTextField();
		zone_Client_saisi.add(tField_client_mail);
		tField_client_mail.setColumns(10);
		zone_Info_client.setLayout(new GridLayout(2, 1, 0, 0));
		zone_Info_client.add(lbl_Infoclient);
		zone_Info_client.add(zone_Client_saisi);
		
		JPanel zone_info_livraison = new JPanel();
		zone_Center.add(zone_info_livraison);
		zone_info_livraison.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lbl_Infolivraison = new JLabel("         Information de livraison");
		zone_info_livraison.add(lbl_Infolivraison);
		
		JPanel zone_Livraison_saisi = new JPanel();
		zone_info_livraison.add(zone_Livraison_saisi);
		zone_Livraison_saisi.setLayout(new GridLayout(0, 4, 5, 5));
		
		JLabel lbl_livraison_ville = new JLabel("Ville :");
		lbl_livraison_ville.setHorizontalAlignment(SwingConstants.RIGHT);
		zone_Livraison_saisi.add(lbl_livraison_ville);
		
		JComboBox combo_livraison_ville = new JComboBox();
		combo_livraison_ville.setModel(new DefaultComboBoxModel(new String[] {"Toulouse", "Paris", "Montpellier", "Lyon", "Marseille", "Nice", "Dijon", "Troyes", "Rennes", "Brest", "Nantes", "Bordeaux", "Strasbourg", "Lille", "Reims", "Toulon", "Saint-Etienne", "Le Havre", "Grenoble", "Angers", "N\u00EEmes", "Le Mans", "Aix-en-Provence", "Perpignan", "Orl\u00E9ans", "Rouen", "Caen", "Nancy", "TourCoing", "Avignon", "Poitiers", "B\u00E9ziers", "Pamiers", "La Rochelle", "Versailles", "Cannes", "Quimper", "Montauban", "Narbonne", "Saint-Andr\u00E9", "Albi", "Carcassonne"}));
		zone_Livraison_saisi.add(combo_livraison_ville);
		
		JLabel lbl_livraison_rue = new JLabel("Rue :");
		lbl_livraison_rue.setHorizontalAlignment(SwingConstants.RIGHT);
		zone_Livraison_saisi.add(lbl_livraison_rue);
		
		tField_livraison_rue = new JTextField();
		zone_Livraison_saisi.add(tField_livraison_rue);
		tField_livraison_rue.setColumns(10);
		
		JLabel lbl_livraison_code_postal = new JLabel("Code Postal :");
		lbl_livraison_code_postal.setHorizontalAlignment(SwingConstants.RIGHT);
		zone_Livraison_saisi.add(lbl_livraison_code_postal);
		
		tField_livraison_codepostal = new JTextField();
		zone_Livraison_saisi.add(tField_livraison_codepostal);
		tField_livraison_codepostal.setColumns(10);
	}

	private void initialize_ZoneButton_South() {
		JPanel zone_Button_South = new JPanel();
		fen_info_client.getContentPane().add(zone_Button_South, BorderLayout.SOUTH);
		
		JButton btn_Sauvegarder = new JButton("Sauvegarder");
		btn_Sauvegarder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		zone_Button_South.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JButton btn_Annuler = new JButton("Annuler");
		btn_Annuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		zone_Button_South.add(btn_Annuler);
		zone_Button_South.add(btn_Sauvegarder);
	}

	private void initialize_ZoneTiter_North() {
		JPanel zone_Titre_North = new JPanel();
		fen_info_client.getContentPane().add(zone_Titre_North, BorderLayout.NORTH);
		String NomImageTiterPager = "ImageFromageTiter";
		zone_Titre_North.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		zone_Titre_North.add(panel, BorderLayout.CENTER);
		
		JLabel lbl_Titre_fromage = new JLabel("Fromage");
		panel.add(lbl_Titre_fromage);
		
		JLabel lbl_Img_fromage = new JLabel("");
		panel.add(lbl_Img_fromage);
		lbl_Img_fromage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImageTiterPager+".png").getPath()));
		
		JLabel lbl_Titre_magasin = new JLabel("Magasin");
		panel.add(lbl_Titre_magasin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		zone_Titre_North.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		Component verticalStrut = Box.createVerticalStrut(1);
		panel_1.add(verticalStrut);
	}

}
