package com.dips.intent;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class MySession implements HttpSession{
	private String ID;
	private HashMap<String,Object> map=new HashMap<String,Object> ();
	public Object getAttribute(String arg0) {
		// TODO Auto-generated method stub
		return map.get(arg0);
	}
	public void setID(String str){
		ID=str;
	}
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getCreationTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return ID;
	}

	public long getLastAccessedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMaxInactiveInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpSessionContext getSessionContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getValue(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getValueNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public void invalidate() {
		// TODO Auto-generated method stub
		
	}

	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

	public void putValue(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public void removeAttribute(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void removeValue(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setAttribute(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(map.get(arg0)!=null){
			map.remove(arg0);
		}
		map.put(arg0, arg1);
		
	}

	public void setMaxInactiveInterval(int arg0) {
		// TODO Auto-generated method stub
		
	}

}
