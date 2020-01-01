# GUI_DBlogs
This utility fetch DB logs and display them on GUI.

# Security Benefits
This code is capable to prevent:
1. SQL injections.
2. XSS attack.

# Setup
1. Database setup is on database.setup file which is for Oracle 12g.
For postgres, Please use below connection commands:
  props.setProperty("user","postuser");
  props.setProperty("password","postpass");
  props.setProperty("ssl","false");
  Class.forName("org.postgresql.Driver");
  return DriverManager.getConnection(jdbc:postgresql://22.421.35.15:5432/BEMUAT,"postuser","postpass");
  
2. Change the username,password in db.properties file
3. Change the schema


