package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import entity.UserInfo;
import utils.dbUtils;

public class RegisterDao {
	public boolean checkNick(String nick) {
		dbUtils conn = new dbUtils();
		String sql = "select u_nick from userInfo where u_nick = ?";
		ResultSet rs = conn.execQuery(sql, new Object[] {nick});
		boolean flag = true;
		try {
			while(rs.next()) {
				rs.getString("u_nick");
				flag = false;
			}
			return flag;
		} catch (SQLException e) {
			// TODO: handle exception
			return flag;
		}finally {
			conn.closeConn();
		}
	}
	
	public boolean checkMail(String email) {
		dbUtils conn = new dbUtils();
		String sql = "select u_email from userinfo where u_email = ?";
		ResultSet rs = conn.execQuery(sql, new Object[] {email});
		boolean flag = true;
		try {
				while (rs.next()) {
					rs.getString(email);
					flag = false;
				}
				return flag;
		} catch (Exception e) {
			// TODO: handle exception
			return  flag;
		}finally {
			conn.closeConn();
		}	
	}
	
	public boolean addUser (UserInfo userInfo) {
		dbUtils conn = new dbUtils();
		String sql = "insert into userinfo (u_email,u_password,u_nick,u_sex,u_addr,u_img) values(?,?,?,?,?,?)";
		int result = 0;
		result = conn.execOther(sql, new Object[] {userInfo.getUserEmail(),userInfo.getUserPassword(),userInfo.getUserNick(),userInfo.getUserSex(),userInfo.getUserAddr(),userInfo.getUserImg()});
		conn.closeConn();
		
		String Sql = "select * from userinfo where u_email =?";
		ResultSet rs = conn.execQuery(Sql, new Object[] {userInfo.getUserEmail()});
		try {
			while(rs.next())
				userInfo.setUserId(rs.getInt("u_id"));
				
				
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result >0?true:false;
	}		
	public UserInfo getInfoByEmail(String email) {
		dbUtils conn = new dbUtils();
		String sql = "select * from userinfo where u_email = ?";
		ResultSet rs = conn.execQuery(sql, new Object[] {email});
		UserInfo userInfo = new UserInfo();
		try {
			while(rs.next()) {
				userInfo.setUserId(rs.getInt("u_id"));
				userInfo.setUserAddr(rs.getString("u_addr"));
				userInfo.setUserSex(rs.getString("u_sex"));
				userInfo.setUserName(rs.getString("u_name"));
				userInfo.setUserImg(rs.getString("u_img"));
				userInfo.setUserDate(rs.getString("u_date"));
			}
			return userInfo;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
