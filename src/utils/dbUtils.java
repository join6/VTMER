package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbUtils {
	static String url="jdbc:mysql://localhost:3306/first?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
	static String user="root";
	static String password="123456";
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	static{
		try {
		//加载数据库驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//创建连接返回驱动
	public static Connection getConnection() throws SQLException{
		Connection conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	//关数据库
	public void closeConn() {
		if(rs!=null)
			try {
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		if(ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
		}
	}
	
	//增删改查的方法
	public int execOther(final String sql,final Object[] params) {
		//1.创建连接
		try {
			getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try {
			ps = conn.prepareStatement(sql);
			for(int i = 0;i < params.length;)
				ps.setObject(i+1, params[i]);
			int affectRows = ps.executeUpdate();
			return affectRows;
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
		//查询语句
		public ResultSet execQuery(final String sql,final Object[] params) {
			try {
				getConnection();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				ps = conn.prepareStatement(sql);
				for(int i = 0;i<params.length;i++) {
					ps.setObject(i+1, params[i]);
				}
				rs = ps.executeQuery();
				return rs;
				}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return  null;
			}
		}
		
	}

