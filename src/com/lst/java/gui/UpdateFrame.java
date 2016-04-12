package com.lst.java.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lst.java.model.Book;

import bookAction.BookAction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField upNumberField;
	private JTextField upNameField;
	private JTextField upAuthorField;
	private JTextField upPriceField;
	private JButton btnNewButton;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFrame frame = new UpdateFrame();
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
	public UpdateFrame() {
		
		setTitle("更新图书");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel upNumberLabel = new JLabel("需更新的图书编号");
		upNumberLabel.setBounds(14, 29, 120, 18);
		contentPane.add(upNumberLabel);
		
		JLabel upNameLable = new JLabel("新的图书名");
		upNameLable.setBounds(14, 76, 72, 18);
		contentPane.add(upNameLable);
		
		JLabel upAuthorLable = new JLabel("新的图书作者");
		upAuthorLable.setBounds(14, 127, 72, 18);
		contentPane.add(upAuthorLable);
		
		JLabel upPriceLable = new JLabel("新的图书价格");
		upPriceLable.setBounds(14, 180, 91, 18);
		contentPane.add(upPriceLable);
		
		upNumberField = new JTextField();
		upNumberField.setBounds(148, 26, 133, 24);
		contentPane.add(upNumberField);
		upNumberField.setColumns(10);
		
		upNameField = new JTextField();
		upNameField.setText("\u53EF\u4EE5\u4E3A\u7A7A");
		upNameField.setToolTipText("");
		upNameField.setBounds(148, 73, 133, 24);
		contentPane.add(upNameField);
		upNameField.setColumns(10);
		
		upAuthorField = new JTextField();
		upAuthorField.setBounds(148, 124, 133, 24);
		contentPane.add(upAuthorField);
		upAuthorField.setColumns(10);
		
		upPriceField = new JTextField();
		upPriceField.setBounds(148, 177, 133, 24);
		contentPane.add(upPriceField);
		upPriceField.setColumns(10);
		
		JButton updateButton = new JButton("更新");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String nu;
				if(( nu=upNumberField.getText())!=null){
					
				Book book=new Book(upNameField.getText(),upAuthorField.getText(),upPriceField.getAlignmentX());
				BookAction ac=new BookAction();
				
				boolean rs=ac.update(book,Integer.parseInt(nu));
				if(rs){
					
					JOptionPane.showMessageDialog(UpdateFrame.this, "success");
					UpdateFrame.this.repaint();
				}else{
					JOptionPane.showMessageDialog(UpdateFrame.this, "default");
					UpdateFrame.this.repaint();
				}
				}
			}
		});
		updateButton.setBounds(158, 213, 113, 27);
		contentPane.add(updateButton);
		
		btnNewButton = new JButton("退出");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateFrame.this.dispose();
			}
		});
		btnNewButton.setBounds(305, 213, 113, 27);
		contentPane.add(btnNewButton);
		
		button = new JButton("主页");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf=new MainFrame();
				UpdateFrame.this.dispose();
				mf.setVisible(true);
			}
		});
		
		button.setBounds(21, 213, 113, 27);
		contentPane.add(button);
	}

}
