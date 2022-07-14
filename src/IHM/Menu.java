package IHM;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import metier.Articles;
import metier.Fromage;
import metier.GenerationFromages;
import metier.Panier;
import metier.TypeLait;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame fen_HomePage;
	private Articles mesArticles;
	private JPanel panel_tout;
	private JPanel panel_vache;
	private JPanel panel_chevre;
	private JPanel panel_brebis;
	private Panier panier;
	private JButton btn_Panier;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.fen_HomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		this.mesArticles = GenerationFromages.générationBaseFromages();
		this.panier = new Panier();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		fen_HomePage = new JFrame();

		fen_HomePage.setBounds(100, 100, 900, 600);
		fen_HomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen_HomePage.getContentPane().setLayout(new BorderLayout(5, 5));
	
		initialize_ZoneHomePage_North();
	}


	
	private void initialize_ZoneHomePage_North() {
		JPanel zone_HomePage_North = new JPanel();
		fen_HomePage.getContentPane().add(zone_HomePage_North, BorderLayout.NORTH);
		zone_HomePage_North.setLayout(new BorderLayout(5, 5));
		
		JPanel zone_PanierPrix_East = new JPanel();
		zone_HomePage_North.add(zone_PanierPrix_East, BorderLayout.EAST);
		zone_PanierPrix_East.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn_Panier = new JButton(String.valueOf(this.panier.getPrixTotalArticle()) + " \u20AC");

		zone_PanierPrix_East.add(btn_Panier);
		String NomImagePanier = "Panier";
		btn_Panier.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImagePanier+".png").getPath()));
		
		JPanel zone_TiterPage_Center = new JPanel();
		zone_HomePage_North.add(zone_TiterPage_Center, BorderLayout.CENTER);
		zone_TiterPage_Center.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbl_TiterFromages = new JLabel("From");
		lbl_TiterFromages.setFont(new Font("Roboto", Font.BOLD, 20));
		zone_TiterPage_Center.add(lbl_TiterFromages);
		
		JLabel lbl_ImageTiterPager = new JLabel("");
		String NomImageTiterPager = "ImageFromageTiter";
		lbl_ImageTiterPager.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImageTiterPager+".png").getPath()));
		zone_TiterPage_Center.add(lbl_ImageTiterPager);
		
		JLabel lbl_TiterMagasin = new JLabel("Age");
		lbl_TiterMagasin.setFont(new Font("Roboto", Font.BOLD, 20));
		zone_TiterPage_Center.add(lbl_TiterMagasin);
		
		JPanel panel_StyleLigneSeparation_South = new JPanel();
		panel_StyleLigneSeparation_South.setBackground(Color.DARK_GRAY);
		zone_HomePage_North.add(panel_StyleLigneSeparation_South, BorderLayout.SOUTH);
		panel_StyleLigneSeparation_South.setLayout(new GridLayout(1, 0, 0, 0));
		
		Component verticalStrut_TailleLigneSeparation = Box.createVerticalStrut(1);
		panel_StyleLigneSeparation_South.add(verticalStrut_TailleLigneSeparation);
		
		JPanel zone_ButtonFermer_West = new JPanel();
		zone_HomePage_North.add(zone_ButtonFermer_West, BorderLayout.WEST);
		
		JButton btn_FermerPage = new JButton("");

		btn_FermerPage.setForeground(Color.WHITE);
		zone_ButtonFermer_West.setLayout(new GridLayout(0, 1, 0, 0));
		String NomImageButtonFermerPage = "logOut";
		btn_FermerPage.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImageButtonFermerPage+".png").getPath()));
		zone_ButtonFermer_West.add(btn_FermerPage);
		
		JPanel zone_HomePage_Center = new JPanel();
		fen_HomePage.getContentPane().add(zone_HomePage_Center, BorderLayout.CENTER);
		zone_HomePage_Center.setLayout(new BorderLayout(0, 10));
		
		JPanel zone_ButtonFilters_North = new JPanel();
		zone_HomePage_Center.add(zone_ButtonFilters_North, BorderLayout.NORTH);
		
		JButton btn_TousAnimaux = new JButton("");
		btn_TousAnimaux.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		zone_ButtonFilters_North.setLayout(new GridLayout(0, 6, 10, 0));
		
		Component horizontalStrut_ZoneButtonFilters_West = Box.createHorizontalStrut(20);
		zone_ButtonFilters_North.add(horizontalStrut_ZoneButtonFilters_West);
		String NomImageTousAnimaux = "tous";
		btn_TousAnimaux.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImageTousAnimaux+".png").getPath()));
		zone_ButtonFilters_North.add(btn_TousAnimaux);
		
		JButton btn_Vaches = new JButton("Vaches");
		
		btn_Vaches.setFont(new Font("Roboto", Font.PLAIN, 14));

		btn_Vaches.setIcon(new ImageIcon(getClass().getClassLoader().getResource("Vaches.png").getPath()));
		zone_ButtonFilters_North.add(btn_Vaches);
		
		JButton btn_Chevres = new JButton("Chevres");
		btn_Chevres.setFont(new Font("Roboto", Font.PLAIN, 14));
		String NomImageChevres = "Chevres";
		btn_Chevres.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImageChevres+".png").getPath()));
		zone_ButtonFilters_North.add(btn_Chevres);
		
		JButton btn_Brebis = new JButton("Brebis");
		btn_Brebis.setFont(new Font("Roboto", Font.PLAIN, 14));
		String NomImageBrebis = "Brebis";
		btn_Brebis.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImageBrebis+".png").getPath()));
		zone_ButtonFilters_North.add(btn_Brebis);
		
		Component horizontalStrut_ZoneButtonFilters_East = Box.createHorizontalStrut(20);
		zone_ButtonFilters_North.add(horizontalStrut_ZoneButtonFilters_East);
		
		JPanel zone_TableauFromages_Center = new JPanel();
		zone_HomePage_Center.add(zone_TableauFromages_Center, BorderLayout.CENTER);
		
		
		
		
		
		zone_TableauFromages_Center.setLayout(new BoxLayout(zone_TableauFromages_Center, BoxLayout.X_AXIS));
		
		panel_tout = new JPanel();
		zone_TableauFromages_Center.add(panel_tout);
		panel_tout.setLayout(new BoxLayout(panel_tout, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_tout.add(scrollPane);
		
		JList liste_fromages = new JList(this.mesArticles.getListFromageAvecDesignation(this.mesArticles.getLesFromages()));
		scrollPane.setViewportView(liste_fromages);
		
		panel_vache = new JPanel();
		zone_TableauFromages_Center.add(panel_vache);
		panel_vache.setLayout(new BoxLayout(panel_vache, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_vache.add(scrollPane_1);
		
		JList liste_fromages_vache = new JList(this.mesArticles.getListFromageAvecDesignation(this.mesArticles.fromageAuLaitDe(TypeLait.VACHE)));
		scrollPane_1.setViewportView(liste_fromages_vache);
		
		panel_chevre = new JPanel();
		zone_TableauFromages_Center.add(panel_chevre);
		panel_chevre.setLayout(new BoxLayout(panel_chevre, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_chevre.add(scrollPane_2);
		
		JList liste_fromages_chevre = new JList(this.mesArticles.getListFromageAvecDesignation(this.mesArticles.fromageAuLaitDe(TypeLait.CHEVRE)));
		scrollPane_2.setViewportView(liste_fromages_chevre);
		
		panel_brebis = new JPanel();
		zone_TableauFromages_Center.add(panel_brebis);
		panel_brebis.setLayout(new BoxLayout(panel_brebis, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_brebis.add(scrollPane_3);
		
		JList liste_fromages_brebis = new JList(this.mesArticles.getListFromageAvecDesignation(this.mesArticles.fromageAuLaitDe(TypeLait.BREBIS)));
		scrollPane_3.setViewportView(liste_fromages_brebis);
		
		constructorInitializePanel();
		constructeurButtonVaches(btn_Vaches, "vache");
		constructeurButtonVaches(btn_Chevres, "chevre");
		constructeurButtonVaches(btn_Brebis, "brebis");
		constructeurButtonVaches(btn_TousAnimaux, "tout");
		
		controleurListAfficherDetails(liste_fromages, this.panier, this);
		controleurListAfficherDetails(liste_fromages_vache, this.panier, this);
		controleurListAfficherDetails(liste_fromages_chevre, this.panier, this);
		controleurListAfficherDetails(liste_fromages_brebis, this.panier, this);
		
		constructeurAjoutPanier(btn_Panier, this.panier, this);
		boutonConstructeurFermer(btn_FermerPage);
		
		
		
		
		
	}

	private void boutonConstructeurFermer(JButton btn_FermerPage) {
		btn_FermerPage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fen_HomePage.dispose();
			}
		});
	}

	private void constructeurAjoutPanier(JButton btn_Panier, Panier panier, Menu menu) {
		btn_Panier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PanierFen fenetrePanier = new PanierFen(panier, menu);
				fenetrePanier.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				fenetrePanier.setVisible(true);
				
				
				
			}
		});
	}

	private void controleurListAfficherDetails(JList liste_fromages, Panier panier, Menu menu) {
		liste_fromages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DetailFromage fenetreDetail = new DetailFromage(mesArticles.getFromageAvecDesignation((String) liste_fromages.getSelectedValue()),panier, menu);
				
				fenetreDetail.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				fenetreDetail.setVisible(true);
			}
		});
	}

	private void constructeurButtonVaches(JButton bouton, String filtre) {
		bouton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_tout.setVisible(false);
				panel_vache.setVisible(false);
				panel_chevre.setVisible(false);
				panel_brebis.setVisible(false);
				switch(filtre) {
					case "vache" :	
						panel_vache.setVisible(true);
						break;
					case "chevre" :	
						panel_chevre.setVisible(true);
						break;
					case "brebis" :	
						panel_brebis.setVisible(true);
						break;
					default :
						panel_tout.setVisible(true);
				}
			}
		});
	}
	
	private void constructorInitializePanel() {
		fen_HomePage.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				panel_vache.setVisible(false);
				panel_chevre.setVisible(false);
				panel_brebis.setVisible(false);
			}
		});
	}
	
	public void setPrixPanier() {
		this.panier.prixTotal();
		btn_Panier.setText(String.format(" %.2f \u20AC",this.panier.getPrixTotalArticle()));

		
	}
		
	

}
