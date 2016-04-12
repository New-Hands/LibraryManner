package bookAction;

import java.util.List;
import java.util.Map;

import com.lst.java.model.Book;

import bookDao.BookDao;

public class BookAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
	}
	public boolean add(Book book){
		
		BookDao dao=new BookDao();
		return dao.addBook(book);
	}
	public boolean del(String name,String author){
		BookDao dao=new BookDao();
		return dao.delBook(name, author);

	}
	public boolean update(Book book,Integer id){
		
		BookDao dao=new BookDao();
		return dao.updateBook(book, id);
		
	}
	public  List<Book> query(){
		
		BookDao dao=new BookDao();
		return dao.query();
		
	}
	
	public  List<Book> query(Map<String,Object> pram){
		BookDao dao=new BookDao();
		return dao.query();
		
	}
	public Book getOne(int id){
		
		BookDao dao=new BookDao();
		return dao.getOne(id);
		
	}

}
