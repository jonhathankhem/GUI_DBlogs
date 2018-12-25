package com.kj.BO;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.kj.controller.CustomException;
import com.kj.controller.controller;

public class CheckInputRequest {

	
	public  String format(String xml) throws IOException, SAXException, ParserConfigurationException {
		 
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = db.parse(new InputSource(new StringReader(xml)));
		 
		OutputFormat format = new OutputFormat(doc);
		format.setIndenting(true);
		format.setIndent(2);
		format.setOmitXMLDeclaration(true);
		format.setLineWidth(Integer.MAX_VALUE);
		Writer outxml = new StringWriter();
		XMLSerializer serializer = new XMLSerializer(outxml, format);
		serializer.serialize(doc);
		 
		return outxml.toString();
		 
		}

	
	  
	public List<controller> GetResultInArrayList(ResultSet rs, String Refnopassed, String schemapassed, String envpassed) throws SQLException
	{
		List<controller> arr=new ArrayList<controller>();
		controller cd=new controller();
		
				do{
					
					cd = new controller();
					cd.setRefno(Refnopassed);
					cd.setSchema(schemapassed);
					cd.setEnv(envpassed);
					cd.setMsg("Result Below");
					//System.out.println(rs.getString("log_subtype"));
					cd.setLog_type(rs.getString("log_type"));
					cd.setLog_subtype(rs.getString("log_subtype"));
					cd.setLog_timestamp(rs.getTimestamp("log_datetime"));
					try{
						cd.setLog_pay(format(rs.getString("log_payload")));
					}
					catch (Exception e)
					{
						cd.setLog_pay("");
					}
					arr.add(cd);
					
					
				
				}while(rs.next());
				return arr;
		
		}


	public PreparedStatement CheckInpRequest( Connection con, String schemapassed,String envpassed) throws CustomException 
	{
		PreparedStatement stmt=null;
		try {
		if (schemapassed.equals("africa") && (envpassed.equals("CIT")||envpassed.equals("SIT")||envpassed.equals("NFT"))) {
			stmt=con.prepareStatement("select log_type,log_subtype,log_datetime,log_payload from khem.logger where log_txn_ref_no=? order by log_datetime asc");
			System.out.println("query fetch");	
		} else if(schemapassed.equals("cards")) {
			stmt=con.prepareStatement("select log_type,log_subtype,log_datetime,log_payload from khem.logger where log_txn_ref_no=? order by log_datetime asc");  
			
		}else if(schemapassed.equals("notification")) {
			stmt=con.prepareStatement("select log_type,log_subtype,log_datetime,log_payload from khem.logger where log_txn_ref_no=? order by log_datetime asc");  
			
		}else if((schemapassed.equals("africa")||schemapassed.equals("cards")) && (envpassed.equals("sunrise"))) {
			stmt=con.prepareStatement("select log_type,log_subtype,log_datetime,log_payload from khem.logger where log_txn_ref_no=? order by log_datetime asc");  
			
		}else
			{throw new CustomException("DATA");}
		
		return stmt;
		
		} catch (SQLException e) {
			//con.close();
			//System.out.println("data fail...");
			throw new CustomException("SQL");
		} 
	}

	public boolean CheckPushInputRequest(String envpassed,String schemapassed)
	{
		if (schemapassed.equals("africa") && (envpassed.equals("SIT")||envpassed.equals("NFT")))
			return true;
		else
			return false;
	}



	public Timestamp CheckBillDate(Connection con,String Refnopassed, String logDateFilter) throws SQLException
	{
		
		java.sql.Timestamp BillDate = java.sql.Timestamp.valueOf("0000-00-00 00:00:00.0");
		PreparedStatement stmt2=null;
		ResultSet rs=null;
		stmt2=con.prepareStatement("Select MAX(log_datetime) From khem.LOGGER where log_txn_ref_no=? and log_subtype like '%BillPayment%' and log_subtype like '%Inbound%'");
		stmt2.setString(1,Refnopassed );
		
			rs = stmt2.executeQuery();
			while(rs.next()){
				BillDate=rs.getTimestamp(1);	
				//System.out.println(BillDate);
				
			}
			
			if (BillDate!=null) {
				
		        //System.out.println("Original bill Date found: "+BillDate);
			}
			else
			{
				
				//System.out.println("else "+logDateFilter);
				logDateFilter=logDateFilter.substring(0, logDateFilter.indexOf('T'))+" "+logDateFilter.substring(logDateFilter.indexOf('T')+1,logDateFilter.length())+":00.0000";
				//System.out.println("else part2: "+logDateFilter);
				BillDate = java.sql.Timestamp.valueOf(logDateFilter);
				//System.out.println(BillDate);
				
			}
		        
		return BillDate;


	}

}
