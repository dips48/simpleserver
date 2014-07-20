

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dips.base.MyHtml;

public class registe extends  HttpServlet{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("初始化中");
	}
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rid="";
		if(request.getSession()==null){
			Random rd=new Random();
			rid=""+rd.nextInt(3000);
			}else{
			rid=request.getSession().getId();
			}
		PrintWriter pw=response.getWriter();
		MyHtml mh=new MyHtml(pw);
		mh.WriteHeader();
		mh.writeFS("input", "Register");
		mh.writeS("用户名：");
		mh.writeT("text", "username");
		mh.writeS("<br/>");
		mh.writeS("密   码:");
		mh.writeT("password", "password");
		mh.writeT("hidden", "rid",rid);
		mh.writeP("submit", "提交");
		mh.writeFE();
		mh.WriteEnd();
		
	}

}
