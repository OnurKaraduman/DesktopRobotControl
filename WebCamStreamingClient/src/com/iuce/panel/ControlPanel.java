package com.iuce.panel;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import com.iuce.constant.Constants;
import com.iuce.constant.MessageConstant;
import com.iuce.protocol.MessagePacket;
import com.iuce.protocol.SenderUDP;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.DatagramSocket;

import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;

public class ControlPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private SenderUDP senderUdp;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public ControlPanel(DatagramSocket socket) {
		setLayout(null);
		senderUdp = new SenderUDP(socket);
		senderUdp.send(MessageConstant.START_COMMINICATION, "Desktop", "nocontent");
		initUI();

	}

	public void initUI() {
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				senderUdp.send(MessageConstant.MESSAGE_COMMAND,
						MessageConstant.MESSAGE_TAG, Constants.COMMAND_GO);
			}
		});
		btnGo.setBounds(114, 48, 89, 45);
		add(btnGo);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.MESSAGE_COMMAND,
						MessageConstant.MESSAGE_TAG, Constants.COMMAND_BACK);
			}
		});
		btnBack.setBounds(114, 169, 89, 45);
		add(btnBack);

		JButton btnRight_1 = new JButton("Right");
		btnRight_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.MESSAGE_COMMAND,
						MessageConstant.MESSAGE_TAG, Constants.COMMAND_RIGHT);
			}
		});
		btnRight_1.setBounds(213, 106, 72, 52);
		add(btnRight_1);

		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.MESSAGE_COMMAND,
						MessageConstant.MESSAGE_TAG, Constants.COMMAND_LEFT);
			}
		});
		btnLeft.setBounds(32, 100, 72, 49);
		add(btnLeft);

		JToggleButton tglbtnAutogear = new JToggleButton("AutoGear");
		tglbtnAutogear.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				System.out.println("change listener triggered");
			}
		});
		tglbtnAutogear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JToggleButton tBtn = (JToggleButton) e.getSource();
				if (tBtn.isSelected()) {
					Constants.control = true;
					senderUdp.send(MessageConstant.MESSAGE_GEAR,
							MessageConstant.MESSAGE_TAG,
							String.valueOf(Constants.control));
				} else {
					Constants.control = false;
					senderUdp.send(MessageConstant.MESSAGE_GEAR,
							MessageConstant.MESSAGE_TAG,
							String.valueOf(Constants.control));
				}
			}
		});
		tglbtnAutogear.setBounds(98, 11, 121, 23);
		add(tglbtnAutogear);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.MESSAGE_COMMAND,
						MessageConstant.MESSAGE_TAG, Constants.COMMAND_STOP);
			}
		});
		btnStop.setBounds(114, 106, 89, 52);
		add(btnStop);

		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constants.SPEED == 100) {
				} else {
					Constants.SPEED = Constants.SPEED + 15;
					senderUdp.send(MessageConstant.MESSAGE_SPEED,
							MessageConstant.MESSAGE_TAG,
							String.valueOf(Constants.SPEED));
				}
			}
		});
		button.setBounds(337, 79, 60, 23);
		add(button);

		JButton button_1 = new JButton("-");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Constants.SPEED == 0) {

				} else {
					Constants.SPEED = Constants.SPEED - 15;
					senderUdp.send(MessageConstant.MESSAGE_SPEED,
							MessageConstant.MESSAGE_TAG,
							String.valueOf(Constants.SPEED));
				}
			}
		});
		button_1.setBounds(337, 113, 60, 23);
		add(button_1);

		textField = new JTextField();
		textField.setBounds(311, 48, 86, 20);
		add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("H_MIN:");
		label.setBounds(27, 252, 46, 14);
		add(label);

		JLabel label_1 = new JLabel("H_MAX:");
		label_1.setBounds(27, 272, 46, 14);
		add(label_1);

		JLabel label_2 = new JLabel("S_MIN:");
		label_2.setBounds(27, 292, 46, 14);
		add(label_2);

		JLabel label_3 = new JLabel("S_MAX:");
		label_3.setBounds(27, 312, 46, 14);
		add(label_3);

		JLabel label_4 = new JLabel("V_MIN:");
		label_4.setBounds(27, 332, 46, 14);
		add(label_4);

		JLabel label_5 = new JLabel("V_MAX:");
		label_5.setBounds(27, 352, 46, 14);
		add(label_5);

		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setBounds(72, 249, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setBounds(72, 269, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setBounds(72, 289, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setBounds(72, 309, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setBounds(72, 329, 86, 20);
		add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setBounds(72, 349, 86, 20);
		add(textField_6);
		textField_6.setColumns(10);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.COLOR_H_MIN_VALUE, "Tag",
						textField_1.getText());
			}
		});
		btnSend.setBounds(168, 248, 89, 23);
		add(btnSend);

		JButton button_2 = new JButton("Send");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.COLOR_H_MAX_VALUE, "Tag",
						textField_2.getText());
			}
		});
		button_2.setBounds(168, 268, 89, 23);
		add(button_2);

		JButton button_3 = new JButton("Send");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.COLOR_S_MIN_VALUE, "Tag",
						textField_3.getText());
			}
		});
		button_3.setBounds(168, 288, 89, 23);
		add(button_3);

		JButton button_4 = new JButton("Send");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.COLOR_S_MAX_VALUE, "Tag",
						textField_4.getText());
			}
		});
		button_4.setBounds(168, 308, 89, 23);
		add(button_4);

		JButton button_5 = new JButton("Send");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.COLOR_V_MIN_VALUE, "Tag",
						textField_5.getText());
			}
		});
		button_5.setBounds(168, 328, 89, 23);
		add(button_5);

		JButton button_6 = new JButton("Send");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				senderUdp.send(MessageConstant.COLOR_V_MAX_VALUE, "Tag",
						textField_6.getText());
			}
		});
		button_6.setBounds(168, 352, 89, 23);
		add(button_6);
		
		JToggleButton tglbtnFollow = new JToggleButton("Follow");
		tglbtnFollow.setBounds(239, 11, 121, 23);
		add(tglbtnFollow);
		
		
		tglbtnFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JToggleButton tBtn = (JToggleButton) e.getSource();
				if (tBtn.isSelected()) {
					Constants.control = true;
					senderUdp.send(MessageConstant.MESSAGE_FOLLOW_OBJECT,
							MessageConstant.MESSAGE_TAG,
							String.valueOf(true));
				} else {
					Constants.control = false;
					senderUdp.send(MessageConstant.MESSAGE_FOLLOW_OBJECT,
							MessageConstant.MESSAGE_TAG,
							String.valueOf(false));
				}
			}
		});
	}
}
