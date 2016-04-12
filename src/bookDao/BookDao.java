package bookDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lst.java.model.Book;

import DBUtil.DBUtil;

public class BookDao {

	public static void main(String[] args) {
		
		BookDao dao=new BookDao();
		List<Map<String,Object>> prams=new ArrayList<>();
		Map<String,Object> pram=new HashMap<>();
		String name="bookName";
		String rea="like";
		String value="'java'";
		pram.put("name",name );
		pram.put("rea",rea);
		pram.put("value",value);
		
		prams.add(pram);
		
	    
		
		List<Book> booklist =dao.query(prams);
		for(int i=0;i<booklist.size();i++){
		System.out.println(booklist.get(i).toString());
		}
	}
	
	public List<Book> query(){
		
		List<Book> bookList=new ArrayList<>();
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
	
		try {
			con =DBUtil.getConnection();
		    String sql="select * from book ";
			ps=con.prepareStatement(sql);
			rs =ps.executeQuery();
			while(rs.next()){
				
				Book book=new Book(rs.getString(2),rs.getString(3),rs.getFloat(4));
				bookList.add(book);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeConnection(con, rs, ps);
		}
		return bookList;
		
	}
    public Book getOne(int num){
    
    	Book book=null;
    	Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		try {
			
			con =DBUtil.getConnection();
			String sql=" select * from book where  id=? ";
			ps=con.prepareStatement(sql);
			ps.setInt(1, num);
			
			rs =ps.executeQuery();
			while(rs.next()){
			
				book=new Book(rs.getString(2),rs.getString(3),rs.getFloat(4));
			
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con, rs,ps);
		}
		return book;
    	
    }
   

    public boolean addBook(Book book){
    	Connection con=null;
    	PreparedStatement ps=null;
    	 boolean rs=false;
    	 try {
			
			con =DBUtil.getConnection();
			String sql=" "+
			"insert into book"+
			"(bookName,bookAuthor,bookPrice)"+
			"values(?,?,?)";
			 ps=con.prepareStatement(sql);
		
			ps.setString(1, book.bookName);
			ps.setString(2,book.bookAuthor);
			ps.setFloat(3, book.bookPrice);
			
			
		    rs=ps.execute();
		 if(ps.getUpdateCount()!=0)
			 rs=true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		DBUtil.closeConnection(con, ps);
		}
    	 
    	 return rs;
    }
    
    public boolean delBook(String name,String author){
     Connection con=null;
     PreparedStatement ps=null;
     boolean rs=false;
   	 try {
			con =DBUtil.getConnection();
			String sql=""+
			" delete from book"+
					" where bookName=? and bookAuthor=?";//空格的问题
			 ps=con.prepareStatement(sql);
		
			
			ps.setString(1, name);
			ps.setString(2, author);
			rs=ps.execute();
			
			 if(ps.getUpdateCount()!=0)
				 rs=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBUtil.closeConnection(con, ps);
			
		}
   	
		 return rs;
    }
    
    public boolean updateBook(Book book,int num){
    	
    	PreparedStatement ps=null;
    	Connection con=null;
    	boolean rs=false;
   	 try {
			
			con =DBUtil.getConnection();
			
			String sql=""+
			" update book"+
					" set bookName=?,bookAuthor=?,bookPrice= ?"+
			" where id= ? ";
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, book.bookName);
			ps.setString(2,book.bookAuthor);
			ps.setFloat(3, book.bookPrice);
			ps.setInt(4, num);
			
			rs=ps.execute();
			 if(ps.getUpdateCount()!=0)
				 rs=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(con, ps);
		}
   	 return rs;
    }
       
	public List<Book> query(List<Map<String,Object>> prams){
    	List<Book> bookList=new ArrayList<>();
    	
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
	
		try {
			 con =DBUtil.getConnection();
			
		 	 StringBuilder sql = new StringBuilder(" select * from book where 1=1 ");
			
			 if(prams!=null&&prams.size()>0){
			
			for(int i=0;i<prams.size();i++)
			{	Map<String,Object> pram=prams.get(i);
				sql.append("and "+pram.get("name")+" "+pram.get("rea")+" "+pram.get("value")+"");
			}
			}
			ps=con.prepareStatement(sql.toString());
			rs= ps.executeQuery();
			while(rs.next()){
				Book book=new Book(rs.getString(2),rs.getString(3),rs.getFloat(4));
				bookList.add(book);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally{
			
			DBUtil.closeConnection(con, rs, ps);
			
		}
		return bookList;
		
    	
    }

}
