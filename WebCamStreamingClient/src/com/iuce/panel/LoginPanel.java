package com.iuce.panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.iuce.constant.Constants;
import com.iuce.thread.ThreadReciever;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class LoginPanel extends JPanel {
	/**
	 * 
	 */
	// region members
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	FacePanel panelImage;

	// endregion
	/**
	 * Create the panel.
	 */
	// region constructor
	public LoginPanel() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(66, 8, 168, 20);
		add(textField);
		textField.setColumns(10);
		textField.setText("9999");

		textField_1 = new JTextField();
		textField_1.setBounds(66, 33, 168, 20);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("192.168.173.147");
		JButton btnConnect = new JButton("Connect");

		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText() != "" && textField_1.getText() != "") {
					setVisible(false);
					Constants.PORT_SERVER = Integer.parseInt(textField
							.getText());
					try {
						Constants.IP_ADDRESS = InetAddress
								.getByName(textField_1.getText());
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					DatagramSocket socket = null;
					try {
						socket = new DatagramSocket();
					} catch (SocketException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					ControlPanel cPanel = new ControlPanel(socket);
					cPanel.setVisible(true);
					JFrame jFrame = new JFrame("Control Panel");
					jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jFrame.setSize(400, 400);
					jFrame.setVisible(true);
					jFrame.setContentPane(cPanel);
					initFrame();

					ThreadReciever recieverThread = new ThreadReciever(socket,
							panelImage);
					recieverThread.start();

				}
			}
		});
		btnConnect.setBounds(142, 65, 89, 23);
		add(btnConnect);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(10, 36, 46, 14);
		add(lblPort);

		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(10, 11, 46, 14);
		add(lblIp);
	}

	// endregion

	// region methods
	public void initFrame() {
		JFrame jframeImage = new JFrame("Image from client");
		jframeImage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframeImage.setSize(400, 400);
		jframeImage.setVisible(true);

		panelImage = new FacePanel();
		jframeImage.setContentPane(panelImage);
	}
	// endregion
}
