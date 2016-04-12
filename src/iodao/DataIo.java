package iodao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import com.lst.java.model.Book;



public class DataIo {
	
	Vector<Book> booklist=new Vector<>();
	public static void main(String[] args) {
		
		DataIo i=new DataIo();
		
		i.loadData();
		i.saveData();
		
	}
	
	public  void loadData(){
		
		FileReader fis = null;
		BufferedReader br=null;
		
		try {
			
			fis = new FileReader(new File("d:\\eclipse\\LibraryManner\\book.txt"));
			br=new BufferedReader(fis);
			String context=null;
			
			while((context=br.readLine())!=null){
				if(context.equals(""))
					break;
				System.out.println(context);
				String[] con=context.split(",");
				
				Book book=new Book(con[0],con[1],Float.parseFloat(con[2]));
				
				booklist.add(book);
			}
	

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}finally{
			if(fis!=null)
				try {
					fis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			 if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}				
		}
	}
	
	
	public void saveData(){
		BufferedWriter ps=null;
		try {
			
			ps=new BufferedWriter(new FileWriter(new File("d:\\eclipse\\LibraryManner\\book.txt"),true));
			
			for(Book b:booklist){
			
				
				ps.write(b.bookName+",");
				ps.write(b.bookAuthor+",");
			 
				ps.write(String.valueOf(b.bookPrice));
				
				ps.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	

}
