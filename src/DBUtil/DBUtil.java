package DBUtil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	
	//静态代码块 加载到虚拟机时 只被执行一次

	private static String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=d:\\eclipse\\LibraryManner\\book.accdb";
	
	static{
		try {
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//加载书数据库驱动 

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}
	
	public static Connection getConnection(){
		
		try {
			return DriverManager.getConnection(url);//获得连接
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static void closeConnection(Connection con,ResultSet rs,PreparedStatement ps){
		
		
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				
				if(con!=null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	public static void closeConnection(Connection con,PreparedStatement ps){
		
		closeConnection(con,null,ps);
		
	}

}
