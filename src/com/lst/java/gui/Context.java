package com.lst.java.gui;


import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lst.java.model.Book;

import bookAction.BookAction;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Context extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Context frame = new Context();
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
	public Context() {
		
		setTitle("查询结果");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BookAction ac=new BookAction();
		
		List<Book> book=ac.query();
		
		Object[][] abook = new Object[book.size()][3];
		//System.out.println(book.get(1).bookAuthor);
		for(int i=0;i<book.size();i++){
			abook[i][0]=book.get(i).bookName;
			abook[i][1]=book.get(i).bookAuthor;
			abook[i][2]=book.get(i).bookPrice;
		}
		String []form={"书名","作者","编号"};
		
		table = new JTable(abook,form);
		table.setBounds(14, 55, 400,200);
	//table.setBounds(x, y, width, height);
		table.setFillsViewportHeight(true);
	
	
		JScrollPane js=new JScrollPane(table);
		js.setBounds(14, 55, 400, 185);
		contentPane.add(js);
		
		
	}
}
