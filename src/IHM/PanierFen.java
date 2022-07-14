package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Panier;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanierFen extends JDialog {
	private JTextField textFieldCodeReduc;
	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextArea txtPanier;
	private Menu menu;
	private JButton btnAcheter_1;
	




	public PanierFen(Panier panier, Menu menu) {

		this.menu = menu;
		setBounds(100, 100, 891, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panelTitre = new JPanel();
				panel.add(panelTitre, BorderLayout.NORTH);
				panelTitre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					JLabel titrePartie1 = new JLabel("From");
					titrePartie1.setFont(new Font("Roboto", Font.BOLD, 20));
					panelTitre.add(titrePartie1);
				}
				{
					JLabel titreLogo = new JLabel("");
					String NomImageTiterPager = "ImageFromageTiter";
					titreLogo.setIcon(new ImageIcon(getClass().getClassLoader().getResource(NomImageTiterPager+".png").getPath()));
					panelTitre.add(titreLogo);
				}
				{
					JLabel titrePartie2 = new JLabel("Age");
					titrePartie2.setFont(new Font("Roboto", Font.BOLD, 20));
					panelTitre.add(titrePartie2);
				}
			}
			{
				JPanel panelAffichage = new JPanel();
				panel.add(panelAffichage, BorderLayout.CENTER);
				panelAffichage.setLayout(new GridLayout(0, 1, 0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panelAffichage.add(scrollPane);
					{
						txtPanier = new JTextArea();
						txtPanier.setFont(new Font("Roboto", Font.PLAIN, 12));
						txtPanier.setText(panier.toString());
						txtPanier.setEditable(false);
						txtPanier.setRows(10);
						txtPanier.setWrapStyleWord(true);
						txtPanier.setLineWrap(true);
						scrollPane.setViewportView(txtPanier);
					}
				}
			}
			{
				JPanel panelSud = new JPanel();
				panel.add(panelSud, BorderLayout.SOUTH);
				panelSud.setLayout(new BoxLayout(panelSud, BoxLayout.Y_AXIS));
				{
					JPanel panelReduction = new JPanel();
					panelSud.add(panelReduction);
					panelReduction.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					{
						JLabel lblCoupon = new JLabel("Code promo");
						lblCoupon.setFont(new Font("Roboto", Font.PLAIN, 12));
						panelReduction.add(lblCoupon);
					}
					{
						textFieldCodeReduc = new JTextField();
						textFieldCodeReduc.setFont(new Font("Roboto", Font.PLAIN, 12));
						textFieldCodeReduc.setColumns(10);
						panelReduction.add(textFieldCodeReduc);
					}
					{
						JButton btnValiderCodeReduc = new JButton("Valider");
						btnValiderCodeReduc.setFont(new Font("Roboto", Font.PLAIN, 12));
						constructeurButtonValiderReduc(btnValiderCodeReduc, textFieldCodeReduc, panier);
						panelReduction.add(btnValiderCodeReduc);
					}
				}
				{
					JPanel panelLivraison = new JPanel();
					panelSud.add(panelLivraison);
					panelLivraison.setLayout(new BoxLayout(panelLivraison, BoxLayout.Y_AXIS));
					{
						JPanel panelTitreLivraison = new JPanel();
						panelLivraison.add(panelTitreLivraison);
						panelTitreLivraison.setLayout(new BorderLayout(0, 0));
						{
							JLabel titreLivraison = new JLabel("Choix de livraison :");
							titreLivraison.setFont(new Font("Roboto", Font.BOLD, 15));
							panelTitreLivraison.add(titreLivraison);
						}
					}
					{
						JPanel panelChoixLivraisoon = new JPanel();
						panelLivraison.add(panelChoixLivraisoon);
						{
							JRadioButton rdbtnLivraisonPointRelais = new JRadioButton("Livraison en point relais : 1.50€");
							rdbtnLivraisonPointRelais.setFont(new Font("Roboto", Font.PLAIN, 12));
							rdbtnLivraisonPointRelais.setSelected(true);
							panier.setPrixLivraison(1.50f);
							txtPanier.setText(panier.toString());
							constructeurChangeLivraison(panier, rdbtnLivraisonPointRelais,1.50f);
							buttonGroup.add(rdbtnLivraisonPointRelais);
							panelChoixLivraisoon.add(rdbtnLivraisonPointRelais);
						}
						{
							JRadioButton rdbtnLivraisonDomicile = new JRadioButton("Livraison à domicile : 5.99€");
							rdbtnLivraisonDomicile.setFont(new Font("Roboto", Font.PLAIN, 12));
							buttonGroup.add(rdbtnLivraisonDomicile);
							constructeurChangeLivraison(panier, rdbtnLivraisonDomicile,5.99f);
							panelChoixLivraisoon.add(rdbtnLivraisonDomicile);
						}
						{
							JRadioButton rdbtnChronopost = new JRadioButton("Chronopost : 3.99€");
							rdbtnChronopost.setFont(new Font("Roboto", Font.PLAIN, 12));
							buttonGroup.add(rdbtnChronopost);
							constructeurChangeLivraison(panier, rdbtnChronopost,3.99f);
							panelChoixLivraisoon.add(rdbtnChronopost);
						}
					}
				}
				{
					JPanel panelBouton = new JPanel();
					panelSud.add(panelBouton);
					panelBouton.setLayout(new BorderLayout(0, 0));
					{
						JPanel boutonGauche = new JPanel();
						panelBouton.add(boutonGauche, BorderLayout.WEST);
						{
							JButton btnRetour = new JButton("Retour");
							btnRetour.setFont(new Font("Roboto", Font.PLAIN, 12));
							constructeurBoutonRetour(btnRetour);
							boutonGauche.add(btnRetour);
						}
						{
							JButton btnViderPanier = new JButton("Vider le panier");
							btnViderPanier.setFont(new Font("Roboto", Font.PLAIN, 12));
							constructeurButtonViderPanier(btnViderPanier, panier);
							boutonGauche.add(btnViderPanier);
						}
					}
					{
						JPanel boutonDroite = new JPanel();
						panelBouton.add(boutonDroite, BorderLayout.EAST);
						{
							btnAcheter_1 = new JButton("Acheter");
							btnAcheter_1.setFont(new Font("Roboto", Font.PLAIN, 12));
							btnAcheter_1.setEnabled(false);
							if (!panier.isEmpty()) {
								btnAcheter_1.setEnabled(true);
							}
							constructeurBoutonAcheter(btnAcheter_1, panier, this.menu, this);
							boutonDroite.add(btnAcheter_1);
						}
					}
				}
			}
		}
	}




	private void constructeurBoutonAcheter(JButton btnAcheter, Panier panier, Menu menu, PanierFen panierFen) {
		btnAcheter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!panier.isEmpty()) {
					ClientFen fenetreClient = new ClientFen(panier, menu, panierFen);
					fenetreClient.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					fenetreClient.setVisible(true);
				}
			}
		});
	}




	private void constructeurButtonValiderReduc(JButton btnValiderCodeReduc, JTextField code, Panier panier) {
		btnValiderCodeReduc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panier.setReduction(code.getText());
				txtPanier.setText(panier.toString());
			}
		});
	}




	private void constructeurBoutonRetour(JButton btnRetour) {
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}




	private void constructeurButtonViderPanier(JButton btnViderPanier, Panier panier) {
		btnViderPanier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panier.reinitialisationPanier();
				txtPanier.setText(panier.toString());
				menu.setPrixPanier();
				btnAcheter_1.setEnabled(false);
			}
		});
	}




	private void constructeurChangeLivraison(Panier panier, JRadioButton choixLivraison, float prix) {
		choixLivraison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panier.setPrixLivraison(prix);
				txtPanier.setText(panier.toString());
			
				
			}
		});
	}

}
