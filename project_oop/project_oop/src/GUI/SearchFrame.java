package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Vehicle;
import MainandSys.VehicleSys;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTF;

	/**
	 * Launch the application.
	 */
	VehicleFrame VF;
	/**
	 * Create the frame.
	 */
	public SearchFrame(VehicleFrame VF) {
		this.VF=VF;
		
		setTitle("Search Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JTextArea displayTA = new JTextArea();
		displayTA.setBounds(55, 87, 424, 175);
		contentPane.add(displayTA);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idTF = new JTextField();
		idTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					String temp = idTF.getText().trim();
					if(temp.isEmpty())
					{
						displayTA.setText("Please Enter ID First!!");
					}
					else
					{
						Vehicle V = VehicleSys.searchVehicle(Integer.parseInt(temp));
						
						if(V == null)
						{
							displayTA.setText("NOT FOUND!!");
						}
						else
						{
							displayTA.setText(V.toString());
						}
					}
				}
			}
		});
		idTF.setBounds(91, 23, 130, 26);
		contentPane.add(idTF);
		idTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(55, 28, 24, 16);
		contentPane.add(lblNewLabel);
		
		JButton searchBTN = new JButton("Search Car");
		searchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = idTF.getText().trim();
				if(temp.isEmpty())
				{
					displayTA.setText("Please Enter ID First!!");
				}
				else
				{
					Vehicle V = VehicleSys.searchVehicle(Integer.parseInt(temp));
					
					if(V == null)
					{
						displayTA.setText("NOT FOUND!!");
					}
					else
					{
						displayTA.setText(V.toString());
					}
				}
			}
		});
		searchBTN.setBounds(362, 23, 117, 29);
		contentPane.add(searchBTN);
		
		
		JButton closeBTN = new JButton("Close");
		closeBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VF.setVisible(true);
				dispose();
			}
		});
		closeBTN.setBounds(362, 286, 117, 29);
		contentPane.add(closeBTN);
		
		JButton clearBTN = new JButton("Clear");
		clearBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayTA.setText("");
				idTF.setText("");
			}
		});
		clearBTN.setBounds(55, 286, 117, 29);
		contentPane.add(clearBTN);
	}
}
