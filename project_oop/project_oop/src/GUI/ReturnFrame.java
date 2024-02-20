package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Inheritance.Car;
import Inheritance.ElectricCar;
import Inheritance.Vehicle;
import MainandSys.VehicleSys;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnFrame extends JFrame {

	private JPanel contentPane;
	private JTextField brandTF;
	private JTextField idTF;
	private JTextField rentDurationTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField kWhTF;
	private JTextField rangeTF;
	private JTextField chargeDurationTF;

	/**
	 * Launch the application.
	 */

	VehicleFrame VF;
	/**
	 * Create the frame.
	 */
	public ReturnFrame(VehicleFrame VF) {
		this.VF=VF;
		
		setTitle("Return Car");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel priceLabel = new JLabel("");
		priceLabel.setBounds(302, 330, 168, 27);
		contentPane.add(priceLabel);
		
		
		JLabel lblNewLabel = new JLabel("Car Type:");
		lblNewLabel.setBounds(38, 40, 61, 16);
		contentPane.add(lblNewLabel);
		
		brandTF = new JTextField();
		brandTF.setBounds(428, 31, 211, 28);
		contentPane.add(brandTF);
		brandTF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Brand:");
		lblNewLabel_1.setBounds(348, 36, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		idTF = new JTextField();
		idTF.setBounds(136, 115, 130, 26);
		contentPane.add(idTF);
		idTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(83, 120, 28, 16);
		contentPane.add(lblNewLabel_2);
		
		JComboBox doorCMB = new JComboBox();
		doorCMB.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4"}));
		doorCMB.setBounds(428, 112, 77, 25);
		contentPane.add(doorCMB);
		
		JLabel lblNewLabel_3 = new JLabel("Number of Doors:");
		lblNewLabel_3.setBounds(281, 116, 135, 16);
		contentPane.add(lblNewLabel_3);
		
		rentDurationTF = new JTextField();
		rentDurationTF.setBounds(136, 195, 130, 26);
		contentPane.add(rentDurationTF);
		rentDurationTF.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Rent Duration:");
		lblNewLabel_4.setBounds(13, 196, 111, 16);
		contentPane.add(lblNewLabel_4);
		
		JRadioButton fuelRB = new JRadioButton("Fuel");
		buttonGroup.add(fuelRB);
		fuelRB.setBounds(428, 196, 77, 23);
		contentPane.add(fuelRB);
		
		JRadioButton dieselRB = new JRadioButton("Diesel");
		buttonGroup.add(dieselRB);
		dieselRB.setBounds(517, 196, 141, 23);
		contentPane.add(dieselRB);
		
		JLabel lblNewLabel_5 = new JLabel("Fuel Type:");
		lblNewLabel_5.setBounds(332, 200, 77, 16);
		contentPane.add(lblNewLabel_5);
		
		kWhTF = new JTextField();
		kWhTF.setBounds(136, 330, 130, 26);
		contentPane.add(kWhTF);
		kWhTF.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Battery Information");
		lblNewLabel_6.setBounds(13, 285, 133, 33);
		contentPane.add(lblNewLabel_6);
		
		rangeTF = new JTextField();
		rangeTF.setBounds(136, 247, 130, 26);
		contentPane.add(rangeTF);
		rangeTF.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Range:");
		lblNewLabel_7.setBounds(49, 250, 50, 21);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("kWh:");
		lblNewLabel_8.setBounds(60, 335, 39, 16);
		contentPane.add(lblNewLabel_8);
		
		chargeDurationTF = new JTextField();
		chargeDurationTF.setBounds(136, 368, 133, 26);
		contentPane.add(chargeDurationTF);
		chargeDurationTF.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Charge Duration:");
		lblNewLabel_9.setBounds(6, 373, 116, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel returnLabel = new JLabel("");
		returnLabel.setBounds(332, 247, 307, 64);
		contentPane.add(returnLabel);
		
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VF.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(482, 407, 157, 33);
		contentPane.add(btnNewButton_1);
		
		
		JComboBox carTypeCMB = new JComboBox();
		carTypeCMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(carTypeCMB.getSelectedIndex() == 0)
				{
					rangeTF.setEditable(false);
					kWhTF.setEditable(false);
					chargeDurationTF.setEditable(false);
					fuelRB.setEnabled(true);
					dieselRB.setEnabled(true);
					
				}
				else
				{
					fuelRB.setEnabled(false);
					dieselRB.setEnabled(false);
					rangeTF.setEditable(true);
					kWhTF.setEditable(true);
					chargeDurationTF.setEditable(true);
				}
			}
		});
		carTypeCMB.setModel(new DefaultComboBoxModel(new String[] {"Car", "ElectricCar"}));
		carTypeCMB.setSelectedIndex(0);
		carTypeCMB.setBounds(136, 36, 133, 27);
		contentPane.add(carTypeCMB);
		
		JButton btnNewButton_2 = new JButton("Calculate Price");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String) carTypeCMB.getSelectedItem();
				String f;
				
				if(fuelRB.isSelected())
					f="Fuel";
				else
					f="Diesel";
				
				Vehicle temp;
				
				if(type.equalsIgnoreCase("Car"))
				{
					temp = new Car(brandTF.getText(), Integer.parseInt(idTF.getText()), Integer.parseInt((String) doorCMB.getSelectedItem()), Integer.parseInt(rentDurationTF.getText()), f);
				}
				else
				{
					temp = new ElectricCar(brandTF.getText(), Integer.parseInt(idTF.getText()), Integer.parseInt((String) doorCMB.getSelectedItem()), Integer.parseInt(rentDurationTF.getText()), Integer.parseInt(rangeTF.getText()), Integer.parseInt(kWhTF.getText()), Integer.parseInt(chargeDurationTF.getText()));
				}
				
				priceLabel.setText(VehicleSys.calculateFee(temp) + "");
			}
		});
		btnNewButton_2.setBounds(482, 330, 157, 27);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("RETURN CAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String) carTypeCMB.getSelectedItem();
				String f;
				
				if(fuelRB.isSelected())
					f="Fuel";
				else
					f="Diesel";
				
				Vehicle temp;
				
				if(type.equalsIgnoreCase("Car"))
				{
					temp = new Car(brandTF.getText(), Integer.parseInt(idTF.getText()), Integer.parseInt((String) doorCMB.getSelectedItem()), Integer.parseInt(rentDurationTF.getText()), f);
				}
				else
				{
					temp = new ElectricCar(brandTF.getText(), Integer.parseInt(idTF.getText()), Integer.parseInt((String) doorCMB.getSelectedItem()), Integer.parseInt(rentDurationTF.getText()), Integer.parseInt(rangeTF.getText()), Integer.parseInt(kWhTF.getText()), Integer.parseInt(chargeDurationTF.getText()));
				}
				
				if(VehicleSys.addVehicle(temp))
					returnLabel.setText("Vehicle Returned!!");
				else
					returnLabel.setText("Vehicle Already Returned!!");
			}
		});
		btnNewButton.setBounds(482, 366, 157, 33);
		contentPane.add(btnNewButton);
	}
}
