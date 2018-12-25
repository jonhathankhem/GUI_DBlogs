package com.kj.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kj.connect.FetchAllLogs;
import com.kj.controller.controller;


/**
 * Servlet implementation class FindLog
 */


public class FindLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//List<controller> arr=new ArrayList<controller>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindLog() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	doPost(request, response);
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//System.out.println(request.getRemoteAddr());
		response.setContentType("text/html");
		String RefNo = request.getParameter("RefNo").replaceAll(" ","");
		String env = request.getParameter("env");
		String schema = request.getParameter("Schema");
		String logDateFilter = request.getParameter("PushDT");
		//System.out.println(request.getParameter("Submit"));
		
		FetchAllLogs dbconnect=new FetchAllLogs();
		List<controller> arr=new ArrayList<controller>();
	try {
		
		
	if (request.getParameter("pushapi") != null)
	{
		System.out.println("yes");
		arr= dbconnect.FindPushLog(RefNo,"africa",env,logDateFilter);
	}
	else
	{
		System.out.println(schema);
		arr= dbconnect.FindLog(RefNo,schema,env);
	}
	//System.out.println(arr);
	//System.out.println("logs done");
	/*for(int i=0;i<arr.size();i++)
	System.out.println(arr.get(i).getLog_subtype());
	System.out.println("kj");
		*/
	request.setAttribute("articles", arr);
	request.getSession().setAttribute("articles", arr);

	       RequestDispatcher dispatcher = request.getRequestDispatcher("/ResultPage.jsp");
	       dispatcher.forward(request, response);
	        
	} 
	
	catch (Exception e) {
		try {
			response.setContentType("text/html");
			String a=e.toString();
			if (a.contains("DB"))
			{	
				request.setAttribute("message", "DB Connectivity Failed!!");
			}else if (a.contains("SQL"))
			{	
				request.setAttribute("message", "Couldn't fetch data from DB!!");
			}else if (a.contains("LOGS"))
			{	
				request.setAttribute("message", "No Logs Found!!");
			}else if (a.contains("DATA"))
			{	
				request.setAttribute("message", "Wrong Schema or Environment selected!!");
			}
			System.out.println(a);
			System.out.print(e);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProcessingRequest.jsp");
			dispatcher.forward(request, response);
		} catch (ServletException e1) {
			
			
		}		
	
		 }
	
	
	}	
}