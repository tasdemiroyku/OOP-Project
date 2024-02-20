package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainandSys.VehicleSys;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VehicleFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VehicleFrame frame = new VehicleFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	SearchFrame sf = new SearchFrame(this);
	ReturnFrame rf = new ReturnFrame(this);
	RentFrame rentF = new RentFrame(this);

	/**
	 * Create the frame.
	 */
	public VehicleFrame() {
		setTitle("DEALS ON WHEELZ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(19, 41, 321, 385);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON1)
				{
					textArea.setText("");
				}
			}
		});
		scrollPane.setViewportView(textArea);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton read = new JButton("Read File");
		read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(VehicleSys.readFromFile())
						textArea.setText("File read successful!!");
					else
					{
						textArea.setText("FILE NOT FOUND!!");
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		read.setBounds(357, 36, 263, 29);
		contentPane.add(read);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sf.setVisible(true);
				setVisible(false);
			}
		});
		search.setBounds(357, 91, 263, 29);
		contentPane.add(search);
		
		JButton returnVehicle = new JButton("Return");
		returnVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rf.setVisible(true);
				setVisible(false);
			}
		});
		returnVehicle.setBounds(357, 154, 263, 29);
		contentPane.add(returnVehicle);
		
		JButton rent = new JButton("Rent");
		rent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentF.setVisible(true);
				setVisible(false);
			}
		});
		rent.setBounds(357, 219, 263, 29);
		contentPane.add(rent);
		
		JButton display = new JButton("Display");
		display.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(VehicleSys.getCars().isEmpty())
				{
					textArea.setText("List is Empty!!");
				}
				else
				{
					textArea.setText(VehicleSys.display());
				}
			}
		});
		display.setBounds(357, 283, 263, 29);
		contentPane.add(display);
		
		JButton displayById = new JButton("Display By ID");
		displayById.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(VehicleSys.getCars().isEmpty())
				{
					textArea.setText("List is Empty!!");
				}
				else
				{
					textArea.setText(VehicleSys.getCarsByID());
				}
				
			}
		});
		displayById.setBounds(357, 342, 263, 29);
		contentPane.add(displayById);
		
		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				
			}
		});
		clear.setBounds(357, 397, 263, 29);
		contentPane.add(clear);
		
		
		
	}
}
