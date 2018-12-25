<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
header, footer {
    padding: 1em;
    color: white;
    background-color: STEELBLUE;
    clear: left;
    text-align: center;
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
<link rel="icon" href="<%=request.getContextPath() %>/search.PNG" />
<title>BEM Log Utility</title>
</head>

<body>

<header><h1  style="text-align: center;">Processing Failed!</h1></header>

<h2 style="margin : 40px auto auto auto; text-align: center"><%out.print(request.getAttribute("message"));%></h2>
<h2 style="margin : 40px auto auto auto; text-align: center"><a href="Welcome.jsp" style="color:steelblue;text-decoration: underline"">Click me to start again..</a></h2>
<div style="margin : 100px auto auto auto; text-align: center"></div>


</body>
</html>