

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
import com.dips.demo.FileExt;

public class add extends  HttpServlet{

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
		FileExt fe=(FileExt)request.getSession().getAttribute("FileExt");
		mh.writeS("欢迎："+request.getSession().getAttribute("title"));
		mh.WriteA("CleanCookie", "退出");
		mh.writeS("当前目录为："+fe.getName());
		mh.writeS("<br/>");
		mh.writeFS("input", "CreateNew");
		mh.writeT("text", "bt");
		mh.writeS("<br/>");
		mh.writeT("text", "content");
		mh.writeT("hidden", "rid",rid);
		mh.writeP("submit", "添加");
		mh.writeFE();
		mh.WriteEnd();
		
	}

}
