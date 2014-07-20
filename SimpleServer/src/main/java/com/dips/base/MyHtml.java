package com.dips.base;


import java.io.PrintWriter;

public class MyHtml {
	PrintWriter pw;
	public MyHtml(PrintWriter pw){
		this.pw=pw;
	}
	public void WriteHeader(){
		pw.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		pw.println("<html>");
		pw.println("<body>");
	}
	public void WriteEnd(){
		pw.println("</body>");
		pw.println("</html>");
	}
	public void WriteA(String url,String name){
		pw.println("<a href=\""+url+"\">"+name+"</a>");
	}
	public void writeT(String type,String name){
		pw.println("<input type=\""+type+"\" name=\""+name+"\">");
	}
	public void writeT(String type,String name,String value){
		pw.println("<input type=\""+type+"\" name=\""+name+"\" value=\""+value+"\">");
	}
	public void writeP(String type,String value ){
		pw.println("<input type=\""+type+"\" value=\""+value+"\"/>");
	}
	public void writeFS(String name,String action){
		pw.println("<form name=\""+name+"\" action=\""+action+"\" method=\"get\">");
	}
	public void writeFS(String name,String action,String value){
		pw.println("<form name=\""+name+"\" action=\""+action+"\" method=\"get\" value=\""+value+"\">");
	}
	public void writeFE(){
		pw.println("</form>");
	}
	public void writeS(String str){
		pw.println(str);
	}

}
