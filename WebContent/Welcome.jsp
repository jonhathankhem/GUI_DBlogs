<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
html {
  height: 100%;
}
body { position:absolute; top:0; bottom:0; right:0; left:0; }
header{
    padding: 1em;
    color: white;
    background-color: STEELBLUE;
    clear: left;
    text-align: center;
   
}
footer {
    color: white;
    background-color: STEELBLUE;
    clear: bottom;
    text-align: center;
    position:absolute;  bottom:0; right:0; left:0;
}
.loader {
  border: 10px solid #f3f3f3;
  border-radius: 50%;
  border-top: 10px solid #3498db;
  width: 120px;
  height: 120px;
  margin-left:46px
  -webkit-animation: spin 20s linear infinite;
  animation: spin 20s linear infinite;
}
@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}
@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
img {
    opacity: 2;
    filter: alpha(opacity=200); /* For IE8 and earlier */
}
</style>
<link rel="icon" href="<%=request.getContextPath() %>/search.PNG" />
<title>BEM Log Utility</title>
</head>

<body >


<form action="QueryResult" method="POST">
 <header><img src="<%=request.getContextPath() %>/imageicon.jpg" style="float:right;width:70px;height:70px;" ><h1 style="text-align: center;" >BEM Log Utility</h1></header>
<img src="<%=request.getContextPath() %>/imageicon1.png" style="float:right;width:1424px;height:25px;" >
<p></p>
<p>&nbsp;</p>

<div>
<p style="margin-left:46px">Unique Reference No: &nbsp;<input style="margin-left:4px" name="RefNo" type="text" value="" />

<p style="margin-left:70px">Environment: 
<select  style="margin-left:40px" name="env">
  <option value="none">NOT SELECTED</option>
  <option value="CIT">CIT</option>
  <option value="SIT">SIT</option>
  <option value="UAT">UAT</option>
  <option value="NFT">NFT</option>  
</select></p>
<p style="margin-left:70px">Schema: 
<select  style="margin-left:73px" name="Schema" id="schema">
  <option value="none">NOT SELECTED</option>
  <option value="cards">CARDS</option>
  <option value="africa">AFRICA</option>
  <option value="notification">NOTIFICATION</option>
</select>
<input  style="margin-left:30px"  name="pushapi" type="checkbox" value="pushapi" onclick="enableDisableEnvironment(this.checked,'schema');hideunhide(this.checked,'pushdt');hideunhide(this.checked,'pushdt2')" >PushAPI
<p style="margin-left:70px;display:none" class="hide" id="pushdt" >Date-From:<input class="hide" style="margin-left: 55px;display=none" type="datetime-local" name="PushDT" >  In BST</p>
<p style="margin-left:70px;display:none"  class="hide" id="pushdt2">Please Enter the date only when the bill transaction date is more than 5 days.</p>
<p></p>

<script type="text/javascript">
function enableDisableEnvironment(isEnabled,tagname) {
	
	document.getElementById(tagname).disabled = isEnabled;
      
    
 }

function hideunhide(enb,tagname) {
	 if (document.getElementById(tagname).className=='hide' && enb==true) {
	    	document.getElementById(tagname).style.display = "block";
	    	document.getElementById(tagname).readOnly=true;
	    	document.getElementById(tagname).className ='show';
	    	//document.getElementById(tagname).enabled = enb;
	    	
	    	
		}
	 else
	 {
		 document.getElementById(tagname).style.display = "none";
	    document.getElementById(tagname).className ='hide';
	}
}
function hidemethod()
{document.getElementById('pushdt').style.display = "none";
}
</script>

 <br>
 <input type="submit"  value="Submit" style="margin-left:150px">
</div>
</form>

<footer>Made by Khemankar Jain</footer>
</body>

</html>
