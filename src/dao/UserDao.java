package dao;

import java.sql.ResultSet;

import entity.UserInfo;
import utils.dbUtils;

public class UserDao {
	//得到用户信息
	public UserInfo getUserInfoById(final int u_id) {
		String sql = "select * from userInfo where u_id = ?";
		dbUtils dbConn = new dbUtils();
		ResultSet rs = dbConn.execQuery(sql, new Object[] {u_id});
		UserInfo userInfo = new UserInfo();
		
		try {
			while(rs.next()) {
				userInfo.setUserId(rs.getInt("u_id"));
				userInfo.setUserDate(rs.getString("u_date"));
				userInfo.setUserName(rs.getString("u_name"));
				userInfo.setUserEmail(rs.getString("u_email"));
				userInfo.setUserAddr(rs.getString("u_addr"));
				userInfo.setUserSex(rs.getString("u_sex"));			
			}
			return userInfo;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		finally {
			dbConn.closeConn();
		}
	}
	//保存用户修改资料
	public boolean updateUserInfo(final UserInfo userInfo, final int userId) {
		String userDate = userInfo.getUserDate();
		String userEmail = userInfo.getUserEmail();
		String userNick = userInfo.getUserNick();
		String userSex = userInfo.getUserSex();
		String userAddr = userInfo.getUserAddr();
		String userName = userInfo.getUserName();
		
		String sql = "update userInfo set u_nick =?,u_sex=?,u_name=?,u_date=?,u_addr=? where u_id = ?";
		dbUtils conn = new dbUtils();
		int flag = conn.execOther(sql,new Object[] {userNick,userSex,userName,userDate,userAddr,userId});
		return flag >0 ? true:false;
	}
}
