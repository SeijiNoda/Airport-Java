/*import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	//private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Enzo\\Desktop\\ECLIPSE\\AirPorts_Interfaces\\src\\Imagens\\Icone.png"));
		frame.setBounds(100, 100, 775, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblAirport = new JLabel("AirFunPort");
		lblAirport.setFont(new Font("Verdana", Font.PLAIN, 40));
		
		JLabel lblA = new JLabel("<html>Your <b>best</b> AirPort Management's Application of all time.</html>");
		lblA.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Enzo\\Desktop\\ECLIPSE\\AirPorts_Interfaces\\src\\Imagens\\imagem_principal.png"));
		
		JLabel label_1 = new JLabel("");
		
		JButton btnVoos = new JButton("Voos");
		btnVoos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		btnVoos.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JButton btnAeroportos = new JButton("Aeroportos");
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
}*/
