/**
 * @author saschint
 *
 */
package com.aembot.gitbotproject.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aembot.gitbotproject.core.services.JsonService;

/**
 * @author saschint
 *
 */
@Component(service= Servlet.class, 
					property={
							Constants.SERVICE_DESCRIPTION + "=JSON Resonse from RESTful Webservice",
							"sling.servlet.methods="+ HttpConstants.METHOD_GET,
							"sling.servlet.paths="+ "/bin/jsonservlet"})
public class JsonServlet extends SlingSafeMethodsServlet{
	
	private static final long serialVersionUID = 1L; 
	
	private static final Logger Logger = LoggerFactory.getLogger(JsonServlet.class);
	
	@Reference
	JsonService jsonService;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String responseFromService = jsonService.getData();
			response.getWriter().write(responseFromService);
			
		} catch (Exception e) {
			Logger.error("Error Occured while trying the servlet {}", e.getMessage());
			
		}
		
		
	}
	
	
}
