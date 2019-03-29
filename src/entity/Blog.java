package entity;

import java.util.Date;

public class Blog {
	private String b_id;
	private String b_content;
	private Date b_time;
	private String userId;
	private String b_img;
	private Date b_data;
	
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public Date getB_time() {
		return b_time;
	}
	public void setB_time(Date b_time) {
		this.b_time = b_time;
	}
	public String getuserId() {
		return userId;
	}
	public void setuId(String userId) {
		this.userId = userId;
	}
	public String getB_img() {
		return b_img;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public Date getB_data() {
		return b_data;
	}
	public void setB_data(Date b_data) {
		this.b_data = b_data;
	}
	public Blog(String b_id, String b_content, Date b_time, String uId, String b_img, Date b_data) {
		super();
		this.b_id = b_id;
		this.b_content = b_content;
		this.b_time = b_time;
		this.userId = userId;
		this.b_img = b_img;
		this.b_data = b_data;
	}
	public  Blog() {}
	
}
