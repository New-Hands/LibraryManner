package com.lst.java.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lst.java.model.Book;

import bookAction.BookAction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7072412011194615257L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField authorField;
	private JTextField priceField;
	private JButton exitButton;
	private JButton homeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFrame frame = new AddFrame();
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
	public AddFrame() {
		setTitle("\u6DFB\u52A0\u56FE\u4E66");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel addLabel = new JLabel("\u4E66\u540D");
		addLabel.setBounds(33, 32, 72, 18);
		contentPane.add(addLabel);
		
		JLabel authorLabel_1 = new JLabel("\u4F5C\u8005");
		authorLabel_1.setBounds(33, 76, 72, 18);
		contentPane.add(authorLabel_1);
		
		JLabel priceLabel_2 = new JLabel("\u4EF7\u683C");
		priceLabel_2.setBounds(33, 117, 72, 18);
		contentPane.add(priceLabel_2);
		
		nameField = new JTextField();
		nameField.setBounds(134, 29, 107, 24);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		authorField = new JTextField();
		authorField.setBounds(134, 73, 107, 24);
		contentPane.add(authorField);
		authorField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setBounds(134, 114, 107, 24);
		contentPane.add(priceField);
		priceField.setColumns(10);
		
		JButton okbutton = new JButton("Ìí¼Ó");
		okbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Book book=new Book(nameField.getText(),authorField.getText(),Float.parseFloat(priceField.getText()));
				BookAction ac=new BookAction();
				boolean rs=ac.add(book);
				if(rs==true){
					JOptionPane.showMessageDialog(AddFrame.this, "success");
					
				}else{
					JOptionPane.showMessageDialog(AddFrame.this, "default");				}
			}
		});
		
		okbutton.setBounds(145, 170, 113, 27);
		contentPane.add(okbutton);
		
		exitButton = new JButton("ÍË³ö");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFrame.this.dispose();
			}
		});
		exitButton.setBounds(284, 170, 113, 27);
		contentPane.add(exitButton);
		
		homeButton = new JButton("Ö÷Ò³");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf=new MainFrame();
				AddFrame.this.dispose();
				mf.setVisible(true);
			}
		});
		homeButton.setBounds(7, 170, 113, 27);
		contentPane.add(homeButton);
		
		
	}
}
