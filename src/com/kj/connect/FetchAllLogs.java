package com.kj.connect;

import com.kj.DAO.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;

import java.util.List;


import oracle.jdbc.OracleTypes;


import com.kj.controller.CustomException;
import com.kj.controller.controller;
import com.kj.BO.CheckInputRequest;

public class FetchAllLogs {
	
	CheckInputRequest chkinp=new CheckInputRequest();
	
	public List<controller> FindLog(String Refnopassed,String schemapassed, String envpassed) throws CustomException
	{
		DBConnection db=new DBConnection();
		Connection con=db.getConnection(envpassed,schemapassed);
		List<controller> arr=new ArrayList<controller>();
		PreparedStatement stmt=null;
		//System.out.println("Fetching from DB");
		boolean flag=false;
		ResultSet  rs=null;
		try {
		stmt=chkinp.CheckInpRequest(con, schemapassed, envpassed);
		System.out.println("Data fetched from DB");
		stmt.setString(1,Refnopassed);
		rs=stmt.executeQuery();
		//rs1=rs;
		System.out.println(rs);
		System.out.println("gere");
		//try {
		if (!rs.next()) {
			System.out.println("no logs");
			flag=true;
			con.close();
			throw new CustomException("LOGS");
		}
		//else{rs1=null;}
		//rs=stmt.executeQuery();
		//}catch(SQLException s)
		//{con.close();throw new CustomException("LOGS");}
		System.out.println("a4");
		arr=chkinp.GetResultInArrayList(rs, Refnopassed, schemapassed, envpassed);
		//System.out.println("a5");
		con.close();
		return arr;
		} catch (SQLException  e) {
			System.out.println(e);
			try {
				if (flag) {
					throw new CustomException("LOGS");
				} else {
					con.close();
					throw new CustomException("SQL");
				}
				
			} catch (SQLException e1) {
				System.out.println("con fail");
				throw new CustomException("SQL");
			}
			
		} 
		
	}




	
	public List<controller> FindPushLog(String Refnopassed, String schemapassed, String envpassed, String logDateFilter) throws CustomException {
		DBConnection db=new DBConnection();
		Connection con=db.getConnection(envpassed,schemapassed);
		List<controller> arr=new ArrayList<controller>();
		Timestamp BillDate = Timestamp.valueOf("0000-00-00 00:00:00.0");
		CallableStatement cStmt=null;
		ResultSet rs=null; 
		boolean flag=false;
		//ResultSet  rs,rs1=null;
		try {
		if (chkinp.CheckPushInputRequest(envpassed,schemapassed)) {
			
			BillDate=chkinp.CheckBillDate( con, Refnopassed, logDateFilter); 
			//System.out.println("Date of billpayment: "+BillDate);
			
			
				cStmt = con.prepareCall("{call FindPushlog(?, ?, ?)}");
				cStmt.setString(1,Refnopassed);
				cStmt.setTimestamp(2,BillDate);
				cStmt.registerOutParameter(3, OracleTypes.CURSOR);
			
		}		
		
	
		
		cStmt.executeQuery();
		rs = (ResultSet) cStmt.getObject(3);
		//rs1=rs;
		if (!rs.next()) {
			//System.out.println("no logs");
			flag=true;
			con.close();
			throw new CustomException("LOGS");
		}
		
		arr=chkinp.GetResultInArrayList(rs, Refnopassed, schemapassed, envpassed);
		con.close();
		return arr;
	} catch (SQLException  e) {
		try {
			if (flag) {
				throw new CustomException("LOGS");
			} else {
				con.close();
				throw new CustomException("SQL");
			}
			
		} catch (SQLException e1) {
			//System.out.println("con fail");
			throw new CustomException("SQL");
		}
		
	} 
		}
	
}