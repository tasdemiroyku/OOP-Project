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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTF;

	/**
	 * Launch the application.
	 */
	

	VehicleFrame VF;
	/**
	 * Create the frame.
	 */
	public RentFrame(VehicleFrame VF) {
		this.VF=VF;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		label.setBounds(150, 68, 226, 39);
		contentPane.add(label);
		
		idTF = new JTextField();
		idTF.setBounds(72, 6, 130, 26);
		contentPane.add(idTF);
		idTF.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(34, 11, 26, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Rent Car");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp = idTF.getText().trim();
				if(temp.isEmpty())
				{
					label.setText("Please Enter ID First!!");
				}
				else
				{
					if(VehicleSys.deleteVehicle(Integer.parseInt(temp)))
					{
						label.setText("Car is rented!!");
					}
					else
					{
						label.setText("This Car is not available!!");
					}
					
				}
			}
		});
		btnNewButton.setBounds(368, 6, 117, 29);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VF.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(179, 156, 176, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText("");
				idTF.setText("");
			}
		});
		btnNewButton_2.setBounds(368, 222, 117, 29);
		contentPane.add(btnNewButton_2);
	}
}
