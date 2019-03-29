package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDao;
import entity.UserInfo;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String nick = request.getParameter("nick");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		String addr = request.getParameter("addr");
		String rpwd = request.getParameter("rpassword");
		
		RegisterDao registerDao = new RegisterDao();
		UserInfo userinfo = new UserInfo();
		userinfo.setUserEmail(email);
		userinfo.setUserSex(sex);
		userinfo.setUserAddr(addr);
		userinfo.setUserPassword(rpwd);
		userinfo.setUserImg("/CodecoreMicroblog/face/NoName.jpg");
		boolean flag=registerDao.addUser(userinfo);
		HttpSession session = null;
		if (flag) {
			session=request.getSession();
			userinfo = registerDao.getInfoByEmail(email);
		}
	}	

}
