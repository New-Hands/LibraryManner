package com.lst.java.gui;

import java.util.Scanner;

import com.lst.java.model.Book;

import bookAction.BookAction;

public class gui {
	
	static String WEL="欢迎登陆图书管理系统\n"
				+ ""
				+ "查询图书请按query/q键\n"
				+ "增加图书请按add/a键\n"
				+ "删除图书请按del/d键\n"
				+ "更新图书请按upd/u键\n"
				+ "退出请按exit/e键";
	
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
					System.out.println("请输入书名");
					Step++;
				}else if(Step==2){
					name=ins;
					System.out.println("请输入作者名");
					Step++;
				}else if(Step==3){
					author=ins;
					System.out.println("请输入价格");
					
					
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
