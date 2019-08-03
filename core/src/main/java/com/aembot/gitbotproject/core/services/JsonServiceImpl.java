package com.aembot.gitbotproject.core.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.osgi.service.component.annotations.Component;


/**
 * @author saschint
 *
 */

@Component(service=JsonService.class,immediate=true)
public class JsonServiceImpl implements JsonService{

	/* (non-Javadoc)
	 * @see com.aembot.gitbotproject.core.services.JsonService#getData()
	 */
	@Override
	public String getData(){
		
		try {
			String url = "https://jsonplaceholder.typicode.com/todos/";
		URL object = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)object.openConnection();
		connection.setRequestMethod("GET");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = bufferedReader.readLine())!= null) {
			response.append(inputLine);
		}
		bufferedReader.close();
		
		return response.toString();
			
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return "Error Occured";
		}
		
	}
	
	

}
