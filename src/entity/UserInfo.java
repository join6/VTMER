package entity;

public class UserInfo {
	private String userEmail;
	private String userName;
	private Integer userId;
	private String userPassword;
	private String userNick;
	private String userDate;
	private String userAddr;
	private String userSex;
	private String userImg;
	public String getUserImg() {
		return userImg;
	}
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public UserInfo(String userEmail, String userName, Integer userId, String userPassword, String userNick,
			String userDate, String userAddr, String userSex,String userImg) {
		super();
		this.userEmail = userEmail;
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userNick = userNick;
		this.userDate = userDate;
		this.userAddr = userAddr;
		this.userSex = userSex;
		this.userImg = userImg;
	}
	public UserInfo() {}
	
	
	
}
