package com.lst.java.gui;

import java.util.Scanner;

import com.lst.java.model.Book;

import bookAction.BookAction;

public class gui {
	
	static String WEL="��ӭ��½ͼ�����ϵͳ\n"
				+ ""
				+ "��ѯͼ���밴query/q��\n"
				+ "����ͼ���밴add/a��\n"
				+ "ɾ��ͼ���밴del/d��\n"
				+ "����ͼ���밴upd/u��\n"
				+ "�˳��밴exit/e��";
	
	static String add="add";
	static String upd="upd";
	static String qyery="query";
	static String del="del";
	static String exit="exit";
	
	
	public static void main(String[] args) {
		int Step=1;
		boolean label=false;
		System.out.println(WEL);
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			
			String ins=in.next();
	
			if(ins.equals(exit))
				break;
			else if(ins.equals(add)||ins.equals(add.substring(0,1).toUpperCase())||label){
				String name=null;
				String author=null;
				float price;
				if(Step==1){
					label=true;
					System.out.println("����������");
					Step++;
				}else if(Step==2){
					name=ins;
					System.out.println("������������");
					Step++;
				}else if(Step==3){
					author=ins;
					System.out.println("������۸�");
					
					
				}else if(Step==4){
					
					price=Float.parseFloat(ins);
					
					Book book=new Book(name,author,price);
					BookAction ac=new BookAction();
					ac.add(book);
					
					Step=1;
				}
				
				
			}
		}
		in.close();
	}
	

}
