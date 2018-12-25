package com.kj.connect;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kj.controller.CustomException;
import com.kj.controller.controller;

/**
 * Servlet implementation class DownloadResult
 */
public class DownloadResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadResult() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
	doPost(request, response);
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		try {
		response.setContentType("application/octet-stream");
		
		ArrayList<controller> arr=new ArrayList<controller>();
		arr=(ArrayList<controller>) request.getSession().getAttribute("arr");
		StringBuffer sb = new StringBuffer("Please find the Logs:\nReference Number:"+arr.get(0).refno+"\nEnvironment:"+arr.get(0).env+"\nSchema:"+arr.get(0).schema+"\n\n");
		for(int i=0;i<arr.size();i++)
			{
			//System.out.println(arr.get(i).getLog_subtype());
			//System.out.println(arr.get(i).getLog_type()+"\t,"+arr.get(i).log_subtype+"\t,"+arr.get(i).getLog_timestamp()+"\t\t,"+arr.get(i).getLogpay()+"\n\n");
			sb=sb.append("["+arr.get(i).getLog_type()+"]\t["+arr.get(i).log_subtype+"]\t["+arr.get(i).getLog_timestamp()+"]\n"+arr.get(i).getLogpay()+"\n\n");
			}
		
			//System.out.println(sb);	
			
		response.setHeader("Content-Disposition","attachment;filename="+arr.get(0).refno+"_"+arr.get(0).env+"_"+arr.get(0).schema+".txt");
		
		InputStream in;
		
			in = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
		
		ServletOutputStream out = response.getOutputStream();
		
		
		
		//ArrayList<byte[]> outputByte=new ArrayList<byte[]>();
		//System.out.println(sb.toString().getBytes("UTF-8").length);
		int n=sb.toString().getBytes("UTF-8").length;
		byte[] outputByte = new byte[n];
		//copy binary contect to output stream
		while(in.read(outputByte, 0, n) != -1)
		{
			out.write(outputByte, 0, n);
		}
		in.close();
		out.flush();
		out.close();
		
		
		
		
		}  catch (IOException e) {
			response.setContentType("text/html");
			request.setAttribute("message", "Please refersh the logs and then try again!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ProcessingRequest.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} 
	}



}
