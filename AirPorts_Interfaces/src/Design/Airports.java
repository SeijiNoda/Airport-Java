package Design;

import ListadeAerorportos.ListaDeAeroportos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Airport.Airport;
import AirportControl.AirportControl;
import ListaDeVoos.ListaDeVoos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Airports extends JFrame {

	private int[] cods;
	
	private JPanel contentPane;
	private JTextField txtCode1;
	private JTextField txtCityName;
	private JTextField txtAirportAbreviation;
	
	JComboBox cbAirports;
	
	private AirportControl lis;

	public Airports(AirportControl lisOriginal) {
		lis = lisOriginal;
		addWindowListener(new WindowAdapter() 
		{
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				new Home(lis).setVisible(true);
			}
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					cods = lis.getLista().getAllCodigos();
				}
				catch(Exception ignore)
				{}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 750, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblAirports = new JLabel("Airports");
		lblAirports.setBounds(10, 11, 190, 50);
		lblAirports.setFont(new Font("Verdana", Font.PLAIN, 40));
		panel.add(lblAirports);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 72, 704, 358);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Airport's Registration", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		label_1.setBounds(275, -87, 480, 440);
		label_1.setIcon(new ImageIcon(Airports.class.getResource("/Imagens/imagem_aeroportos.png")));
		
		JLabel lblNewLabel = new JLabel("Airport's Code");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 158, 26);
		panel_1.add(lblNewLabel);
		
		txtCode1 = new JTextField();
		txtCode1.setBounds(20, 48, 86, 20);
		panel_1.add(txtCode1);
		txtCode1.setColumns(10);
		
		JLabel lblCitysName = new JLabel("City's Name");
		lblCitysName.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCitysName.setBounds(10, 100, 158, 26);
		panel_1.add(lblCitysName);
		
		txtCityName = new JTextField();
		txtCityName.setBounds(20, 137, 245, 20);
		panel_1.add(txtCityName);
		txtCityName.setColumns(10);
		
		JLabel lblCitysName_1 = new JLabel("Airport's Abbreviation");
		lblCitysName_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCitysName_1.setBounds(10, 179, 238, 26);
		panel_1.add(lblCitysName_1);
		
		txtAirportAbreviation = new JTextField();
		txtAirportAbreviation.setBounds(20, 216, 86, 20);
		panel_1.add(txtAirportAbreviation);
		txtAirportAbreviation.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String cityName = txtCityName.getText();
					int code = Integer.parseInt(txtCode1.getText());
					String abbreviation = txtAirportAbreviation.getText();
					Airport airport = new Airport(cityName, code, abbreviation);
					lis.addAirport(airport);
					
					txtCityName.setText("");
					txtCode1.setText("");
					txtAirportAbreviation.setText("");
					JOptionPane.showMessageDialog(null, lis.toString());
					txtCode1.requestFocus();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRegister.setBounds(80, 269, 129, 33);
		panel_1.add(btnRegister);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Specified Airport's Routes", null, panel_2, null);
		panel_2.setLayout(null);
		
		JTextArea txtRoutesUnique = new JTextArea();
		txtRoutesUnique.setBounds(10, 55, 679, 264);
		txtRoutesUnique.setEnabled(false);
		panel_2.add(txtRoutesUnique);
		
		JLabel lblNewLabel_1 = new JLabel("Airport's Code");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 11, 142, 33);
		panel_2.add(lblNewLabel_1);
		
		cbAirports = new JComboBox();
		cbAirports.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent arg0)
			{
				try
				{
					int code = (int) cbAirports.getSelectedItem();
					
					ListaDeVoos lis2 = lis.getLista().getListaDeVoosDeDeterminadoAeroporto(code);
					txtRoutesUnique.setText(lis2.toString());
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cbAirports.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				try
				{
					cbAirports.removeAllItems();
					cods = lis.getLista().getAllCodigos();
					int qtd = cods.length;
					for(int i = 0; i < qtd; i++)
						cbAirports.addItem(cods[i]);
				}
				catch(Exception ex)
				{}
			}
		});
		cbAirports.setBounds(175, 21, 69, 20);
		panel_2.add(cbAirports);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("All Airport's Routes", null, panel_3, null);
		panel_3.setLayout(null);
		
		JTextArea txtRoutes = new JTextArea();
		txtRoutes.setBounds(10, 11, 679, 265);
		panel_3.add(txtRoutes);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String allVoos = "";
					int qtd = cods.length;
					for(int i = 0; i < qtd; i++)
					{
						ListaDeVoos listaVoos = lis.getLista().getListaDeVoosDeDeterminadoAeroporto(cods[i]);
						allVoos += listaVoos.toString() + "\n";
					}
					txtRoutes.setText(allVoos);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSearch.setBounds(290, 286, 118, 33);
		panel_3.add(btnSearch);
	}
}
