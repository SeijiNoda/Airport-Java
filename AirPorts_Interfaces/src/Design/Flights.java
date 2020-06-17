package Design;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Airport.Airport;
import AirportControl.AirportControl;
import ListadeAerorportos.ListaDeAeroportos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Flights extends JFrame {

	private JPanel contentPane;
	private JTextField txtRouteNumber;
	private JComboBox txtCityIndex;
	
	private AirportControl lis;
	private int[] cods;

	public Flights(AirportControl lisOriginal) {
		lis = lisOriginal;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) 
			{
				try
				{
					new Home(lis).setVisible(true);
				}
				catch(Exception ignore) {}
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					cods = lis.getLista().getAllCodigos();
				}
				catch(Exception ignore) {}
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
		
		JLabel lblFlights = new JLabel("Flights");
		lblFlights.setFont(new Font("Verdana", Font.PLAIN, 40));
		lblFlights.setBounds(10, 11, 134, 50);
		panel.add(lblFlights);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 72, 704, 358);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Flight's Registration with Unique Id", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Airport's Code");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 147, 26);
		panel_1.add(lblNewLabel);
		
		JComboBox cbAirports = new JComboBox();
		cbAirports.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e)
			{
				try
				{
					cbAirports.removeAllItems();
					int qtd = cods.length;
					for(int i = 0; i < qtd; i++)
						cbAirports.addItem(cods[i]);
				}
				catch(Exception ex)
				{}
			}
		});
		cbAirports.setBounds(20, 48, 70, 20);
		panel_1.add(cbAirports);
		
		JLabel lblCitysIndex = new JLabel("City's Index");
		lblCitysIndex.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblCitysIndex.setBounds(10, 89, 147, 26);
		panel_1.add(lblCitysIndex);
		
		JLabel lblRoutesNumber = new JLabel("Route's Number");
		lblRoutesNumber.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblRoutesNumber.setBounds(10, 167, 169, 26);
		panel_1.add(lblRoutesNumber);
		
		txtRouteNumber = new JTextField();
		txtRouteNumber.setColumns(10);
		txtRouteNumber.setBounds(20, 204, 86, 20);
		panel_1.add(txtRouteNumber);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Flights.class.getResource("/Imagens/imagem_voos_certo.png")));
		label.setBounds(252, 48, 418, 261);
		panel_1.add(label);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int code = (int) cbAirports.getSelectedItem();
					int cityIndex = (int) txtCityIndex.getSelectedItem();
					int routeNumber = Integer.parseInt(txtRouteNumber.getText());
					Airport airport = lis.getLista().getAirportPeloCodigo(code);
					lis.addRoute(airport, cityIndex, routeNumber);
					
					JOptionPane.showMessageDialog(null, "Registered!", "Register", JOptionPane.INFORMATION_MESSAGE);
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRegister.setBounds(67, 267, 140, 42);
		panel_1.add(btnRegister);
		
		txtCityIndex = new JComboBox();
		txtCityIndex.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCityIndex.removeAllItems();
				int qtd = cods.length;
				for(int i = 0; i < qtd; i++) 
					if(!(cods[i]==(int)cbAirports.getSelectedItem()))
						txtCityIndex.addItem(cods[i]);
			}
		});
		txtCityIndex.setBounds(20, 126, 70, 20);
		panel_1.add(txtCityIndex);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Flight's Deletion", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblRoutesNumber_1 = new JLabel("Route's Number");
		lblRoutesNumber_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblRoutesNumber_1.setBounds(39, 137, 180, 26);
		panel_2.add(lblRoutesNumber_1);
		
		JLabel lblRoutesNumber_1_1 = new JLabel("Airport's Code");
		lblRoutesNumber_1_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblRoutesNumber_1_1.setBounds(39, 26, 180, 26);
		panel_2.add(lblRoutesNumber_1_1);
		
		JComboBox cbCodes = new JComboBox();
		cbCodes.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try
				{
					cbCodes.removeAllItems();
					int qtd = cods.length;
					for(int i = 0; i < qtd; i++)
						cbCodes.addItem(cods[i]);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cbCodes.setBounds(49, 63, 70, 20);
		panel_2.add(cbCodes);
		
		JComboBox cbRouteNumber = new JComboBox();
		cbRouteNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				try
				{
					Airport airportSearched = lis.getLista().getAirportPeloCodigo((int)cbCodes.getSelectedItem());
					int[] routeNumbers = airportSearched.getRoutes().getAllRouteNumbersPeloCodigoAeroporto(airportSearched.getAirportCode());
					
					cbRouteNumber.removeAllItems();
					int qtd = routeNumbers.length;
					for(int i = 0; i < qtd; i++)
						cbRouteNumber.addItem(routeNumbers[i]);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cbRouteNumber.setBounds(49, 174, 70, 20);
		panel_2.add(cbRouteNumber);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Flights.class.getResource("/Imagens/imagem_voos2.png")));
		label_1.setBounds(424, 98, 251, 120);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Flights.class.getResource("/Imagens/image_voos_2_2.png")));
		label_2.setBounds(229, 39, 275, 234);
		panel_2.add(label_2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(JOptionPane.showConfirmDialog(null, "Are you sure to delete this route?", "DELETION", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
							==JOptionPane.YES_OPTION)
					{
						Airport airportSearched = lis.getLista().getAirportPeloCodigo((int)cbCodes.getSelectedItem());
						int routeNumber = (int) cbRouteNumber.getSelectedItem();
						JOptionPane.showMessageDialog(null, routeNumber);
						airportSearched.getRoutes().remova(routeNumber);
						
						JOptionPane.showMessageDialog(null, "DELETED");
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnDelete.setBounds(73, 252, 127, 44);
		panel_2.add(btnDelete);
	}
}
