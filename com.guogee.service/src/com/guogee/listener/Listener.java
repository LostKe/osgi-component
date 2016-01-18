package com.guogee.listener;

import org.osgi.service.http.HttpService;

import com.guogee.service.HttpAction;

public class Listener{

	private HttpService httpService;
	
	public void setHttp(HttpService httpService){
		System.out.println("setHttp!!!!");
		this.httpService=httpService;
	}

	public void startup(){
		try {
			httpService.registerServlet("/demo", new HttpAction(), null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void shutdown(){
		httpService.unregister("/demo");
	}
}
