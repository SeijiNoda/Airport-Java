package Design;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import AirportControl.AirportControl;
import ListadeAerorportos.ListaDeAeroportos;

public class Home extends JFrame {

	private JPanel contentPane;
	
	private static AirportControl lisOriginal = new AirportControl();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(lisOriginal);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Home(AirportControl lis) {
		lisOriginal = lis;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Enzo\\Desktop\\ECLIPSE\\AirPorts_Interfaces\\src\\Imagens\\Icone.png"));
		setBounds(100, 100, 775, 490);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblAirport = new JLabel("AirFunPort");
		lblAirport.setFont(new Font("Verdana", Font.PLAIN, 40));
		
		JLabel lblA = new JLabel("<html>Your <b>best</b> AirPort Management's Application of all time.</html>");
		lblA.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Enzo\\Desktop\\ECLIPSE\\AirPorts_Interfaces\\src\\Imagens\\imagem_principal.png"));
		
		JLabel label_1 = new JLabel("");
		
		JButton btnVoos = new JButton("Flights");
		btnVoos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
		        new Flights(lisOriginal).setVisible(true); 
			}
		});
		btnVoos.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JButton btnAeroportos = new JButton("Airports");
		btnAeroportos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setVisible(false);
		        new Airports(lisOriginal).setVisible(true); 
			}
		});
		btnAeroportos.setFont(new Font("Verdana", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(35)
									.addComponent(lblAirport, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnVoos, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
										.addComponent(btnAeroportos, 0, 0, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(108)
							.addComponent(lblA, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAirport)
					.addGap(17)
					.addComponent(lblA)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(label)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(87)
							.addComponent(btnVoos, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
							.addComponent(btnAeroportos, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(74))))
		);
		panel.setLayout(gl_panel);
	}
}

