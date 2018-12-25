<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="ca" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cb" %>
 
<%@page import="java.util.ArrayList"%>
<%@page import="com.kj.controller.controller"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
header{
    padding: 1em;
    color: white;
    background-color: STEELBLUE;
    clear: left;
    text-align: center;
   
}
#logdet
{
	
     color: white;
    background-color: STEELBLUE;
    
    
}
.no-js #loader { display: none;  }
.js #loader { display: block; position: absolute; left: 100px; top: 0; }
.se-pre-con {
	position: fixed;
	left: 0px;
	top: 0px;
	width: 100%;
	height: 100%;
	z-index: 9999;
	background: url(Preloader_3.gif) center no-repeat #fff;
}
.images ul li img {
	width: 400px;
	height: 266px;
}
.images ul li {
	display: inline-block;
}
.loader {
  border: 10px solid #f3f3f3;
  border-radius: 50%;
  border-top: 10px solid #3498db;
  width: 120px;
  height: 120px;
  /*margin:auto;*/
  -webkit-animation: spin 1s linear infinite;
  animation: spin 1s linear infinite;
}
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}
@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

</style>

<title>BEM Logs</title>
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js'></script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type='text/javascript' src='loadImg.js'></script>
<script type='text/javascript'>
    $(function(){$('data').imgPreload();}); 
</script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.2/modernizr.js"></script>
<script type='text/javascript'>
//paste this code under the head tag or in a separate js file.
	// Wait for window load
	$(window).load(function(){$(".loader").fadeOut("fast");});
	
</script>
<link rel="icon" href="<%=request.getContextPath() %>/search.PNG" />
</head>

<body >

 <div class="loader" style="margin : 100px auto auto auto; text-align: center"></div>

 	
 	<div class="data">
 	<table border="3" bordercolor="black"  style="width:100%">
 	
  <tr style="width:100%" bgcolor="#ffb347" >
    <th style="text-align:left;"  >Log_Type</th>
    <th style="text-align:left"  >Log_subtype</th> 
    <th style="text-align:left" >Log Datetime</th>
    <th style="text-align:left" >Log Payload</th>
  </tr>
<cb:set var="count" value="0"/>

<ca:forEach items="${articles}" var="article" >  
     
 	 	<cb:if test="${count=='0'}">
 	 	<header><h1><ca:out value="${article.msg}"/></h1></header>
 	 	<form action="DownloadResult" method="POST">  
 <%
 session.setAttribute("arr",request.getSession().getAttribute("articles"));
 
%>	 	

<div id="logdet" style="width:100%" >
  	<div style="width:30%;float:left;overflow:auto;text-align:left"  >Reference Number : '<ca:out value="${article.refno}"/>'</div>
  	<div style="width:25%;float:left;overflow:auto;text-align:center" >Environment : <ca:out value="${article.env}"/></div>
  	<div style="width:25%;float:left;overflow:auto;text-align:center" >Schema : <ca:out value="${article.schema}"/></div>
  	<div style="width:20%;text-align:right;overflow:auto;"><input type="submit"  name="submit"  value="Download Result"></div>
<p></p></div></form>			 			  			  
 		 	<cb:set var="count" value="1"/>
  		</cb:if>
  	<tr >
  
  			
    <td style="width:15%"><font face="Verdana" size="2"><ca:out value="${article.log_type}"/></font></td>
    <td style="width:15%"><font face="Verdana" size="2"><ca:out value="${article.log_subtype}"/></font></td>
    <td style="width:15%"><font face="Verdana" size="2"><ca:out value="${article.log_timestamp}"/></font></td>
    <td style="width:55%"><textarea readonly="readonly" rows="10" style="width:100%"  ><ca:out value="${article.logpay}"/></textarea> 
  </td>
  </tr>
    
  </ca:forEach>

 	</table>   
 	</div>
 	




</body>

</html>