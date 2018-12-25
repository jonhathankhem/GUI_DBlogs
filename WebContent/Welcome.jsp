<html>
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
footer {
    padding: 1em;
    color: white;
    background-color: STEELBLUE;
    clear: bottom;
    text-align: center;
    margin:280px 0 0 0;
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
</style>
<title>BEM Logs</title>
</head>

<body>

<form action="QueryResult" method="POST">
 <header><h1 style="text-align: center;">BEM Log Utility!</h1></header>
<p>
<p>&nbsp;</p>

<section>
<p style="margin-left:46px">Unique Reference No.: &nbsp;<input name="RefNo" type="text" value="" />

<p style="margin-left:46px">&nbsp;&nbsp;&nbsp;&nbsp;Environment: 
<select  style="margin-left:46px" name="env">
  <option value="none">NOT SELECTED</option>
  <option value="CIT">CIT</option>
  <option value="SIT">SIT</option>
  <option value="NFT">NFT</option>
 </select>
<p style="margin-left:46px">&nbsp;&nbsp;&nbsp;&nbsp;Schema: 
<select  style="margin-left:79px" name="Schema" id="schema">
  <option value="none">NOT SELECTED</option>
  <option value="cards">CARDS</option>
  <option value="africa">AFRICA</option>
  <option value="notification">NOTIFICATION</option>
 </select>
<input name="pushapi" type="checkbox" value="pushapi" onclick="enableDisableEnvironment(this.checked,'schema');enableLoader(this.checked,'load'); " >PushAPI
<p style="margin-left:200px"><input id="hide" type="datetime-local" name="PushDT"></p>

</section>

<script>
function enableDisableEnvironment(isEnabled,tagname) {
    document.getElementById(tagname).disabled = isEnabled;
    //document.getElementById('load').style.visibility="visible";
    //<div  class="loader" style="margin :0" id="loading"></div>
    //<aside><div  class="loader" style="margin :auto auto auto auto" id="loading"></div></aside>
}


</script>  <br>
 <input type="submit"  value="Submit" style="margin-left:150px">
</form>
</body>
<footer>Made by Khemankar</footer>
</html>