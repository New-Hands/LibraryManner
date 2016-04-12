package com.lst.java.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import bookAction.BookAction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -821144297436323057L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField authorField;
	private JButton homeButton;
	private JButton exitButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFrame frame = new DeleteFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteFrame() {
		setTitle("É¾³ýÍ¼Êé");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel delLable = new JLabel("É¾³ýÍ¼Êé");
		delLable.setBounds(32, 39, 72, 18);
		contentPane.add(delLable);
		
		JLabel authorLable = new JLabel("×÷Õß");
		authorLable.setBounds(32, 92, 72, 18);
		contentPane.add(authorLable);
		
		nameField = new JTextField();
		nameField.setBounds(148, 36, 134, 24);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		authorField = new JTextField();
		authorField.setBounds(148, 89, 134, 24);
		contentPane.add(authorField);
		authorField.setColumns(10);
		
		JButton delButton = new JButton("É¾³ý");
		delButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  BookAction ac=new BookAction();
			  
			  boolean rs=ac.del(nameField.getText(), authorField.getText());
			  if(rs){
				  JOptionPane.showMessageDialog(DeleteFrame.this, "success");
			  }else
			  {
				  JOptionPane.showMessageDialog(DeleteFrame.this, "default");
			  }
			  
			}
		});
		delButton.setBounds(163, 185, 113, 27);
		contentPane.add(delButton);
		
		homeButton = new JButton("Ö÷Ò³");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		homeButton.setBounds(32, 185, 113, 27);
		contentPane.add(homeButton);
		
		exitButton = new JButton("ÍË³ö");
		exitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			DeleteFrame.this.dispose();
			}
		});
		exitButton.setBounds(290, 185, 113, 27);
		contentPane.add(exitButton);
	}
}
