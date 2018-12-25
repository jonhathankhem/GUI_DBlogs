package com.kj.controller;


import java.sql.Timestamp;

public class controller {
	
	public  String msg=null,log_type=null,refno=null,schema=null,env=null,log_subtype=null,logpay=null;
	public Timestamp log_timestamp=null;

 public Timestamp getLog_timestamp() {
		return log_timestamp;
	}

	public void setLog_timestamp(Timestamp timestamp) {
		this.log_timestamp = timestamp;
	}

	public String getLogpay() {
		return logpay;
	}

	public void setLogpay(String logpay) {
		this.logpay = logpay;
	}

public  void setRefno(String refno) {
	 this.refno = refno;
	}

	public   void setSchema(String schema) {
		this.schema = schema;
	}

	public  void setEnv(String env) {
		this.env = env;
	}


/**
 * @return the log_type
 */
public  String getLog_type() {
	return log_type;
}

/**
 * @param log_type the log_type to set
 */
public  void setLog_type(String log_type) {
	this.log_type = log_type;
}

/**
 * @return the log_subtype
 */
public  String getLog_subtype() {
	return log_subtype;
}

/**
 * @param log_subtype the log_subtype to set
 */
public  void setLog_subtype(String log_subtype) {
	this.log_subtype = log_subtype;
}

/**
 * @return the log_payload
 */
public  String getLog_pay() {
	return logpay;
}

/**
 * @param log_payload the log_payload to set
 */
public  void setLog_pay(String log_payload) {
	this.logpay = log_payload;
}


public  String getRefno() {
	return refno;
}

public  String getSchema() {
	return schema;
}

public  String getEnv() {
	return env;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}


}