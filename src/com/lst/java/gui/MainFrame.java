package com.lst.java.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
					Container contentPane = frame.getContentPane();  
				    contentPane.setBackground(Color.CYAN); // 将JFrame实例背景设置为蓝绿色  
				    JPanel panel = new JPanel(); // 创建一个JPanel的实例  
				    panel.setBackground(Color.blue); // 将JPanel的实例背景
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		
		setTitle("lst图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton queryButton = new JButton("查询图书");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				QueryFrame qf=new QueryFrame();
				qf.setVisible(true);
				MainFrame.this.setVisible(false);
				
			}
		});
		queryButton.setBounds(144, 38, 113, 27);
		contentPane.add(queryButton);
		
		JButton updateButton = new JButton("修改图书");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateFrame updateframe=new UpdateFrame();
				updateframe.setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		updateButton.setBounds(144, 118, 113, 27);
		contentPane.add(updateButton);
		
		JButton deleteButton = new JButton("删除图书");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteFrame deleteframe=new DeleteFrame();
				deleteframe.setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		deleteButton.setBounds(144, 158, 113, 27);
		contentPane.add(deleteButton);
		
		JButton addButton = new JButton("添加图书");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddFrame addframe=new AddFrame();
				addframe.setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		addButton.setBounds(144, 78, 113, 27);
		contentPane.add(addButton);
		
		JButton exitButton = new JButton("退出系统");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.this.dispose();
			}
		});
		exitButton.setBounds(305, 213, 113, 27);
		contentPane.add(exitButton);
	}
}
