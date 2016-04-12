package com.lst.java.gui;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.PrintWriter;

import java.util.Objects;
import java.util.Scanner;
import java.util.Vector;

import com.lst.java.model.Book;


public class LibraryManner {

	Vector<Book> Book=new Vector<Book>();
	private Scanner in4;
	private Scanner in5;
	private Scanner in;
	private Scanner in3;
	private Scanner in2; 
	
	
	public LibraryManner() throws ClassNotFoundException{
			loadData();
			int s=0;
		
			System.out.println("��ӭ����ͼ��ݹ���ϵͳ��");
			while(s==0)
			{
			System.out.println("��ѯ�밴-------------1��");
			System.out.println("ɾ���밴-------------2��");
			System.out.println("�޸��밴-------------3��");
			System.out.println("�����밴-------------4��");
			System.out.println("�˳��밴-------------5��");
			in = new Scanner(System.in);
			if(in.hasNext())
				System.out.println("fassdf");
			int op=in.nextInt();
			System.out.println(op);
			switch(op)
			{
			case 1:
				select();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				add();
				break;
			case 5:
				s=1;
				savaDatatwo();
				break;
			}
		
			}	
			System.out.println("���˳�����ϵͳ");
		}
		private void loadData() {
		// TODO Auto-generated method stub
			File file=new File("D:/eclipse/LibraryManner/book.txt");
			file.setWritable(true);

			try {
				Scanner fis=new Scanner(file);
				while(fis.hasNext())
				{
					Book book=new Book();
					book.bookName=fis.next();
					
					book.bookPrice=fis.nextFloat();
					book.bookAuthor=fis.next();
					Book.add(book);
				}
		
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		protected void update(){
			System.out.println("������Ҫ�޸ĵ��鼮��");
			in2 = new Scanner(System.in);
			String name=in2.next();
			
			for(int i=0;i<Book.size();i++)
			{
				if(Objects.equals(Book.get(i).bookName, name))
				{
					
					System.out.println("�ҵ��鼮"+Book.get(i).toString());
					System.out.println("ƥ������밴a��������������Ϣ�ո����");
					
					String nameT=in2.next();
					if(nameT.equals("a"))
						continue;

				
					Book.get(i).bookName=nameT;
					System.out.println(nameT);
					Book.get(i).bookAuthor=in2.next();
					System.out.println(Book.get(i).bookAuthor);
					Book.get(i).bookPrice=(float)in2.nextInt();
				
					break;
				}
				if(i==Book.size()-1)
				{
					System.out.println("δ��ѯ�����鼮��Ϣ");
				}
				
			}
			
		}
		protected void delete(){
			in3 = new Scanner(System.in);
			System.out.println("��ӡͼ���б�");
			print();
			for(int i=0;i<Book.size();i++)
			{
			
				System.out.println("������Ҫɾ�����鼮��");
				String name=in3.nextLine();
				if(Objects.equals(Book.get(i).bookName, name))
				{
					System.out.println("ɾ���ҵ��鼮"+Book.get(i).toString());
					Book.remove(i);
					
					break;
				}
				if(i==Book.size()-1)
				{
					System.out.println("δ��ѯ�����鼮��Ϣ");
					break;
				}
			
			}
		}
		protected void add(){
			in4 = new Scanner(System.in);
		
				System.out.println("������Ҫ��ӵ�ͼ����Ϣ");
				
				String bookName=in4.nextLine();
				String Athour=in4.nextLine();
				float price=in4.nextFloat();
				Book book=new Book(bookName,Athour,price);
				Book.add(book);
				
				System.out.println("��ӡͼ���б�");
				print();
			}
			
		protected void select(){
			in5 = new Scanner(System.in);
			System.out.println("��ӡͼ���б�");
			print();
			for(int i=0;i<Book.size();i++)
			{
				System.out.println("������Ҫ��ѯ���鼮��");
				String name=in5.next();
				if(Objects.equals(Book.get(i).bookName,name))
				{
					System.out.println(Book.get(i).toString());
					
					break;
				}
				if(i==Book.size()-1)
				{
					System.out.println("δ��ѯ�����鼮��Ϣ");
				}
			}	
		
		}	
	
		void savaDatatwo(){
			File file=new File("D:/eclipse/LibraryManner/book.txt");
			try {
				int i=0;
				Book book;
				PrintWriter out=new PrintWriter(file);
				while(true){
					
				book=Book.get(i);
				out.write(book.bookName+" ");
				out.write((int) book.bookPrice+" ");
				out.write(book.bookAuthor+" ");
				
				if(++i==Book.size())break;

				}
				
				file.setReadOnly();
			
				out.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		protected void print(){
			if(Book.size()==0)
				{
					System.out.println("��ǰ��ͼ��");
				}
			Book book;
			for(int i=0;i<Book.size();i++)
			{
				book=Book.get(i);
				System.out.println("��"+(i+1)+"��:"+book.toString());
			}
		}
		public static void main(String[] args) throws ClassNotFoundException {
			// TODO Auto-generated method stub
	
			new LibraryManner();
		}
		


}
