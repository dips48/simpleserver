

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class edit extends  HttpServlet{

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
		System.out.println("��ʼ����");
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
		mh.writeS("��ӭ��"+request.getSession().getAttribute("title"));
		mh.WriteA("CleanCookie", "�˳�");
		mh.writeS("��ǰĿ¼Ϊ��"+fe.getName());
		mh.writeS("<br/>");
		mh.writeS("����Ϊ��");
		mh.writeS("<br/>");
		mh.writeFS("edit", "UploadFile");
		mh.writeT("text",fe.getName(),fe.getContent());
		mh.writeT("hidden", "rid",rid);
		mh.writeS("<br/>");
		mh.writeP("submit", "�޸�");
		mh.writeFE();
		mh.writeS("<p>");
		ArrayList<String> strArray=fe.subFile;
		for(int i=0;i<strArray.size();i++){
			mh.WriteA("GetFil?FileName="+strArray.get(i), strArray.get(i));
			mh.writeS("<br/>");
		}
		mh.WriteEnd();
		
	}

}
