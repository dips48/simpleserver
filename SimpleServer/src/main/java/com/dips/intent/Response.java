package com.dips.intent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class Response implements HttpServletResponse{
	private static final int BUFFER_SIZE=1024;
	Request request;
	OutputStream output;
	PrintWriter writer;
	public Response(OutputStream output){
		this.output=output;
	}
	public void setRequest(Request request){
		this.request=request;
	}
	public void SendStaticResrource() throws IOException{
		byte[] bytes=new byte[BUFFER_SIZE];
		FileInputStream fis=null;
		try{
			File file=new File(App.WEB_ROOT,request.getUri());
			if(file.exists()){
				fis=new FileInputStream(file);
				int ch=fis.read(bytes,0,BUFFER_SIZE);
				while(ch!=-1){
					output.write(bytes,0,ch);
					ch=fis.read(bytes, 0, BUFFER_SIZE);
				}
			}else{
				String errorMessage = "HTTP/1.1 404 File Not Found\r\n" + 
						 "Content-Type: text/html\r\n" + 
						 "Content-Length: 23\r\n" + 
						 "\r\n" + 
						 "<h1>File Not Found</h1>"; 
						 output.write(errorMessage.getBytes()); 
						 } 

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(fis!=null){
				fis.close();
			}
		}
	}
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		
	}
	public int getBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return null;
	}
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		writer = new PrintWriter(output, true); 
		return writer;
	}
	public boolean isCommitted() {
		// TODO Auto-generated method stub
		return false;
	}
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	public void resetBuffer() {
		// TODO Auto-generated method stub
		
	}
	public void setBufferSize(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setContentLength(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setLocale(Locale arg0) {
		// TODO Auto-generated method stub
		
	}
	public void addCookie(Cookie arg0) {
		// TODO Auto-generated method stub
		
	}
	public void addDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}
	public void addHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
	public void addIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	public boolean containsHeader(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	public String encodeRedirectURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String encodeRedirectUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String encodeURL(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String encodeUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public String getHeader(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return null;
	}
	public Collection<String> getHeaders(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void sendError(int arg0) throws IOException {
		// TODO Auto-generated method stub
		
	}
	public void sendError(int arg0, String arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}
	public void sendRedirect(String arg0) throws IOException {
		// TODO Auto-generated method stub
		URL[] urls=new URL[1];
		URLStreamHandler streamHandler=null;
		File classPath=new File(Constants.WEB_ROOT);
		String repository =(new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;
		urls[0]=new URL(null,repository,streamHandler);
		System.out.println(repository);
		URLClassLoader loader=new URLClassLoader(urls);
		Class myclass=null;
		try {
			myclass=loader.loadClass(arg0);
		HttpServlet servlet=null;
		servlet=(HttpServlet)myclass.newInstance();
		servlet.service(request,this);} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void setDateHeader(String arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setHeader(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setIntHeader(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void setStatus(int arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}
}
