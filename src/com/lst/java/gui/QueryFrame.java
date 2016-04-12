package com.lst.java.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryFrame extends JFrame {

	/**
	 * 查询图书  
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NameField;
	private JTextField AuthorField;
	private JTextField NumberField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryFrame frame = new QueryFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.构造函数
	 */
	public QueryFrame() {
		setBackground(new Color(0, 0, 255));
		setTitle("查询图书");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("图书名");
		nameLabel.setBounds(14, 47, 72, 18);
		contentPane.add(nameLabel);
		
		JLabel authorLabel = new JLabel("图书作者");
		authorLabel.setBounds(218, 47, 72, 18);
		contentPane.add(authorLabel);
		
		JLabel priceLabel = new JLabel("图书编号");
		priceLabel.setBounds(442, 50, 72, 18);
		contentPane.add(priceLabel);
		
		NameField = new JTextField();
		NameField.setBounds(73, 44, 112, 24);
		contentPane.add(NameField);
		NameField.setColumns(10);
		
		AuthorField = new JTextField();
		AuthorField.setBounds(304, 44, 112, 24);
		contentPane.add(AuthorField);
		AuthorField.setColumns(10);
		
		NumberField = new JTextField();
		NumberField.setBounds(520, 44, 112, 24);
		contentPane.add(NumberField);
		NumberField.setColumns(10);
		
		JButton queryButton = new JButton("查询");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
							
			}
		});
		queryButton.setBounds(165, 132, 113, 27);
		contentPane.add(queryButton);
		
		JButton homeButton = new JButton("主页");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QueryFrame.this.dispose();
				MainFrame mf=new MainFrame();
				mf.setVisible(true);
			
				
			}
		});
		homeButton.setBounds(14, 132, 113, 27);
		contentPane.add(homeButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QueryFrame.this.dispose();
			}
		});
		exitButton.setBounds(304, 132, 113, 27);
		contentPane.add(exitButton);
		
		JViewport  queryPort=new JViewport();
		queryPort.setBounds(0, 190, 618, 250);
		contentPane.add(queryPort);
		
		
	}
}
