package com.lst.java.model;


public class Book {
	
	public String bookName;
	public String bookAuthor;
	public float bookPrice;


	public Book(String bookName, String bookAuthor,float bookPrice) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
	}
	public Book(){
	
	}

	public static void main(String[] args) {
		
	}

	@Override
	public String toString() {
		return "bookname:"+bookName +","+"bookathour:"+ bookAuthor + ","+"bookprice:"+  bookPrice  ;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

}
