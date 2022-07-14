package IHM;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.Fromage;
import metier.Panier;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class DetailFromage extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jfieldQuantitéRestante;
	private JComboBox comboBoxTypeVente;
	private JSpinner SpinnerQuantitéSelectionner;
	private JButton btnNewButton_2;


	/**
	 * Create the dialog.
	 * @param menu 
	 */
	public DetailFromage(Fromage fromage, Panier panier, Menu menu) {
		setBounds(100, 100, 694, 422);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelCentre = new JPanel();
			contentPanel.add(panelCentre, BorderLayout.CENTER);
			panelCentre.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JPanel panelDescription = new JPanel();
				panelCentre.add(panelDescription);
				panelDescription.setLayout(new BoxLayout(panelDescription, BoxLayout.X_AXIS));
				{
					JScrollPane scrollPane = new JScrollPane();
					panelDescription.add(scrollPane);
					{
						JTextArea descriptionFromage = new JTextArea(fromage.getDescription());
						descriptionFromage.setFont(new Font("Roboto", Font.PLAIN, 12));
						descriptionFromage.setWrapStyleWord(true);
						descriptionFromage.setLineWrap(true);
						descriptionFromage.setEditable(false);
						descriptionFromage.setColumns(38);
						descriptionFromage.setTabSize(5);
						descriptionFromage.setRows(11);
						scrollPane.setViewportView(descriptionFromage);
					}
				}
				{
					JPanel panelPhoto = new JPanel();
					panelDescription.add(panelPhoto);
					panelPhoto.setLayout(new BoxLayout(panelPhoto, BoxLayout.Y_AXIS));
					{
						JLabel lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon(getClass().getClassLoader().getResource("ImageFromageArticle2.png").getPath()));
						panelPhoto.add(lblNewLabel);
					}
					{
						JPanel panelQuantitéRestante = new JPanel();
						panelPhoto.add(panelQuantitéRestante);
						{
							JLabel textquantitéRestante = new JLabel("Quantité restante :");
							textquantitéRestante.setFont(new Font("Roboto", Font.PLAIN, 12));
							panelQuantitéRestante.add(textquantitéRestante);
						}
						{
							jfieldQuantitéRestante = new JTextField();
							jfieldQuantitéRestante.setFont(new Font("Roboto", Font.PLAIN, 12));
							
							jfieldQuantitéRestante.setEditable(false);
							panelQuantitéRestante.add(jfieldQuantitéRestante);
							jfieldQuantitéRestante.setColumns(10);
						}
					}
				}
			}
		}
		
		{
			JLabel titreFromage = new JLabel(fromage.getDésignation());
			titreFromage.setFont(new Font("Roboto", Font.BOLD, 15));
			titreFromage.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(titreFromage, BorderLayout.NORTH);
		}
		{
			JPanel panelSud = new JPanel();
			contentPanel.add(panelSud, BorderLayout.SOUTH);
			{
				JPanel panelTypeVente = new JPanel();
				panelSud.add(panelTypeVente);
				{
					comboBoxTypeVente = new JComboBox();
					comboBoxTypeVente.setFont(new Font("Roboto", Font.PLAIN, 13));
					
					comboBoxTypeVente.setModel(new DefaultComboBoxModel(fromage.getArticles().toArray()));
					comboBoxTypeVente.setSelectedIndex(0);
					actualisationQuantité(fromage);
					
					panelTypeVente.add(comboBoxTypeVente);
				}
			}
			{
				JPanel panelQuantité = new JPanel();
				panelSud.add(panelQuantité);
				{
					JLabel lblQuantité = new JLabel("Quantité :");
					lblQuantité.setFont(new Font("Roboto", Font.PLAIN, 12));
					panelQuantité.add(lblQuantité);
				}
				{
					SpinnerQuantitéSelectionner = new JSpinner();
					SpinnerQuantitéSelectionner.setFont(new Font("Roboto", Font.PLAIN, 12));
					SpinnerQuantitéSelectionner.setModel(new SpinnerNumberModel(0,0, fromage.getArticles().get(comboBoxTypeVente.getSelectedIndex()).getQuantitéEnStock(),1));
					panelQuantité.add(SpinnerQuantitéSelectionner);
				}
			}
		}
		
		jfieldQuantitéRestante.setText(String.valueOf(fromage.getArticles().get(comboBoxTypeVente.getSelectedIndex()).getQuantitéEnStock()));
		
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JPanel panelButtonRetour = new JPanel();
				buttonPane.add(panelButtonRetour, BorderLayout.WEST);
				{
					JButton btnNewButton = new JButton("Retour");
					btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 12));
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					panelButtonRetour.add(btnNewButton);
					
				}
			}
			{
				JPanel panelButtonPanier = new JPanel();
				buttonPane.add(panelButtonPanier, BorderLayout.EAST);
				{
					btnNewButton_2 = new JButton("Ajouter au panier");
					btnNewButton_2.setFont(new Font("Roboto", Font.PLAIN, 12));
					
					panelButtonPanier.add(btnNewButton_2);
				}
			}
		}
		{
			JPanel panelTitre = new JPanel();
			getContentPane().add(panelTitre, BorderLayout.NORTH);
			{
				JLabel titrePartie1 = new JLabel("From");
				titrePartie1.setFont(new Font("Roboto", Font.BOLD, 20));
				panelTitre.add(titrePartie1);
			}
			{
				JLabel titreLogo = new JLabel("");
				titreLogo.setIcon(new ImageIcon("C:\\Users\\xbayc\\OneDrive\\Documents\\Semestre 2\\SAE\\2.01\\Image\\ImageFromageTiter.png"));
				panelTitre.add(titreLogo);
			}
			{
				JLabel titrePartie2 = new JLabel("Age");
				titrePartie2.setFont(new Font("Reem Kufi", Font.BOLD, 20));
				panelTitre.add(titrePartie2);
			}
			
			
		}
		putButtonAjoutPanier(btnNewButton_2, panier, fromage,SpinnerQuantitéSelectionner, menu );
		
	}


	private void putButtonAjoutPanier(JButton btnNewButton_1, Panier panier, Fromage fromage, JSpinner spinnerQuantité, Menu menu ) {
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panier.addArticle(fromage.getArticles().get(comboBoxTypeVente.getSelectedIndex()), (int) spinnerQuantité.getValue());
				jfieldQuantitéRestante.setText(String.valueOf(fromage.getArticles().get(comboBoxTypeVente.getSelectedIndex()).getQuantitéEnStock()));
				SpinnerQuantitéSelectionner.setModel(new SpinnerNumberModel(0,0, fromage.getArticles().get(comboBoxTypeVente.getSelectedIndex()).getQuantitéEnStock(),1));
				menu.setPrixPanier();
			}
		});
	}


	private void actualisationQuantité(Fromage fromage) {
		comboBoxTypeVente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfieldQuantitéRestante.setText(String.valueOf(fromage.getArticles().get(comboBoxTypeVente.getSelectedIndex()).getQuantitéEnStock()));
				SpinnerQuantitéSelectionner.setModel(new SpinnerNumberModel(0, 0, fromage.getArticles().get(comboBoxTypeVente.getSelectedIndex()).getQuantitéEnStock(), 1));
			}
		});
	}

}
