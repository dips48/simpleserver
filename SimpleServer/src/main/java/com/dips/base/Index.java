package com.dips.base;


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

public class Index extends HttpServlet{

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

	public void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rid="";
		rid=arg0.getSession().getId();
		PrintWriter pw=arg1.getWriter();
		MyHtml mh=new MyHtml(pw);
		mh.WriteHeader();
		  mh.writeS("<script language=\"JavaScript\" type=\"text/javascript\">");
		  mh.writeS("document.cookie=\"id=12\"");                // ����cookie�ļ���ֵ
		  mh.writeS("document.cookie=\"user=yx\"");                // ����cookie�ļ���ֵ
	      mh.writeS("var strCookie=document.cookie");            // ��ȡ�������µ�����cookieֵ
		mh.writeS("alert(strCookie)");                        // ��ʾ���е�cookie�ļ���ֵ
		mh.writeS("</script>");
		mh.WriteA("login?rid="+rid, "��½");
		mh.WriteA("registe?rid="+rid, "ע��");
		mh.WriteEnd();
		
	}

}
