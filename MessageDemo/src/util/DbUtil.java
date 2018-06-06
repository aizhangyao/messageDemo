package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库连接工具类
 * @author zy
 *
 */
public class DbUtil {

	
private static Properties props = new Properties();
	
	static{
		InputStream is = null;
		
		is = DbUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//获得连接
	public static Connection getConnection(){
		Connection conn = null; 
		try {
			Class.forName((String)props.get("driver"));
			//ip地址 + 数据库名称
			conn = DriverManager.getConnection((String)props.get("url"), (String)props.get("username"), (String)props.get("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	public static void release(ResultSet rs, Statement stmt, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Connection con = DbUtil.getConnection();
		System.out.println(con.toString());
	}
}
