package com.dips.intent;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String WEB_ROOT="D:\\test";
    public static  HashMap<String,MySession> seMap=new HashMap<String,MySession> ();
    private static final String SHUTDOWN_COMMAND="/SHUTDOWN";
	private boolean shutdown=false;
	public static void main(String args[]){
		new App().await();
	}
	public void await(){
		ServerSocket serverSocket=null;
		int port=880;
		try{
			serverSocket =new ServerSocket(port);
			while(!shutdown){
				try{
				Socket socket=null;
				InputStream input=null;
				OutputStream output=null;
				socket=serverSocket.accept();
				input=socket.getInputStream();
				output=socket.getOutputStream();
				Request request=new Request(input);
				request.parse();
				Response response=new Response(output);
				response.setRequest(request);
				if(request.getUri().contains("servlet")){
					ServletProcessor1 processor=new ServletProcessor1();
					processor.process(request, response);
				}else{
					StaticResourceProcessor processor=new StaticResourceProcessor();
					processor.process(request, response);
				}
				socket.close(); 
				shutdown = request.getUri().equals(SHUTDOWN_COMMAND);}catch(Exception e){
					e.printStackTrace();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
