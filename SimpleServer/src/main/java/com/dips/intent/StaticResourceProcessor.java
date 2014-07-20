package com.dips.intent;

import java.io.IOException;

public class StaticResourceProcessor {
	public void process(Request request,Response response){
		try{
			response.SendStaticResrource();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
