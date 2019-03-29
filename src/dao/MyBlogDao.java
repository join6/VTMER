package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Blog;
import utils.dbUtils;

public class MyBlogDao {
	
	public List<Blog>getMyBlogByUid(final int uid,int pageSize,int pageNo){
		List<Blog> mybloglist = new ArrayList<Blog>();
		String sql = "select * from blog where u_id = (select u_id from userInfo where u_id = ?) order by b_time desc limit ?,?";
		dbUtils dbConn = new dbUtils();
		ResultSet rs = dbConn.execQuery(sql, new Object[] {uid, pageSize*(pageNo-1),pageSize});
		
		try {
			while(rs.next()) {
				Blog myblog = new Blog();
				myblog.setB_content(rs.getString("b_content"));
				myblog.setB_time(rs.getDate("b_time"));
				myblog.setB_data(rs.getTime("b_time"));
				myblog.setB_img(rs.getString("b_img"));
				//封装到集合中
				mybloglist.add(myblog);
			}
			return mybloglist;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		finally {
			dbConn.closeConn();
		}
	}
	
}
