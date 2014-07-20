package com.dips.intent;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.Random;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class ServletProcessor1 {
	public void process(Request request,Response response){
		String uri=request.getUri();
		String servletName=uri.substring(uri.lastIndexOf('/')+1);
		URLClassLoader loader=null;
		try{
			URL[] urls=new URL[1];
			URLStreamHandler streamHandler=null;
			File classPath=new File(Constants.WEB_ROOT);
			String repository =(new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
			urls[0]=new URL(null,repository,streamHandler);
			System.out.println(repository);
			loader=new URLClassLoader(urls);
			Class myclass=null;
			System.out.println(servletName);
			int index=servletName.indexOf('?');
			if(index>0){
				String param=servletName.substring(index+1);
				servletName=servletName.substring(0,index);	
				System.out.println(param);
				System.out.println(servletName);
				int temp=param.indexOf('=');
				while(temp>0){
					int andindex=param.indexOf('&');
					if(andindex<0){
						request.setAttribute(param.substring(0,temp),param.substring(temp+1));
						System.out.println(param.substring(0,temp));
						System.out.println(param.substring(temp+1));
						break;
					}else{
						request.setAttribute(param.substring(0,temp),param.substring(temp+1,andindex));
						System.out.println(param.substring(0,temp));
						System.out.println(param.substring(temp+1,andindex));
					}
					param=param.substring(andindex+1);
					temp=param.indexOf('=');
				}
			}else{
				System.out.println("手动添加");
				Random rd=new Random();
				request.setAttribute("rid",""+rd.nextInt(3000));
			}
			System.out.println(request.getParameter("rid"));
			request.getIntHeader(request.getParameter("rid"));
			System.out.println(request.getContentType());
			if(App.seMap.get(request.getContentType())==null){
				System.out.println("没有找到");
				MySession ms=new MySession();
				ms.setID(request.getContentType());
				App.seMap.put(request.getContentType(), ms);
			}
			myclass=loader.loadClass("com.dips.base."+servletName);
			HttpServlet servlet=null;
			servlet=(HttpServlet)myclass.newInstance();
			servlet.service(request,response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
