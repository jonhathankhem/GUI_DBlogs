package com.kj.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.kj.controller.CustomException;

public class DBConnection {


		public  Connection getConnection(String env,String schema) throws CustomException {
			
			if (!(env.equals("CIT" )|| env.equals("SIT" )|| env.equals("NFT" )|| env.equals("sunrise" )) || !( schema.equals("cards")||schema.equals("africa")||schema.equals("notification")))
			{
				//System.out.println("hi");
				throw new CustomException("DATA");
			}
			
			Properties props = new Properties();
			//FileInputStream fis = null;
			Connection con = null;
			try{
				InputStream inp = getClass().getClassLoader().getResourceAsStream("db.properties");
				props.load(inp);
				
				inp.close();
				Class.forName(props.getProperty("driverclass"));
				System.out.println(props.getProperty("driverclass"));
				System.out.println(props.getProperty("url"));
				System.out.println(props.getProperty("user"));
				System.out.println(props.getProperty("password"));
				// create the connection now
				con = DriverManager.getConnection(props.getProperty("url"),
						props.getProperty("user"),
						props.getProperty("password"));
			
			return con;
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw new CustomException("DB");
			
			}
		}
}
		