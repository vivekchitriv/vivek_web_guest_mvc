<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<style>
* {
  box-sizing: border-box;
}

.row::after {
  content: "";
  clear: both;
  display: table;
}

[class*="col-"] {
  float: left;
  padding: 15px;
}

html {
  font-family: "Lucida Sans", sans-serif;
}

.header {
  background-color: #9933cc;
  color: #ffffff;
  padding: 15px;
}

.menu ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.menu li {
  padding: 8px;
  margin-bottom: 7px;
  background-color: #33b5e5;
  color: #ffffff;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}

.menu li:hover {
  background-color: #0099cc;
}

.aside {
  background-color: #33b5e5;
  padding: 15px;
  color: #ffffff;
  text-align: center;
  font-size: 14px;
  box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}

.footer {
  background-color: #0099cc;
  color: #ffffff;
  text-align: center;
  font-size: 12px;
  padding: 15px;
}

@media only screen and (min-width: 768px) {
  /* For desktop: */
  .col-1 {width: 8.33%;}
  .col-2 {width: 16.66%;}
  .col-3 {width: 50%;}
  .col-4 {width: 33.33%;}
  .col-5 {width: 41.66%;}
  .col-6 {width: 50%;}
  .col-7 {width: 58.33%;}
  .col-8 {width: 66.66%;}
  .col-9 {width: 75%;}
  .col-10 {width: 83.33%;}
  .col-11 {width: 91.66%;}
  .col-12 {width: 100%;}
}
</style>
		<title>Welcome To TAJ PALACE HOTEL</title>
</head>
<body>
<c:choose>
		<c:when test="${!empty result}">
			<h5>${result}</h5>
		</c:when>
	</c:choose>
	<div class="header">
  		<h1>THE TAJ PALACE</h1>
 	</div>
 
	 <div class="row">
  		<div class="col-3 col-s-3 menu">
    		
		    	<a class="linkproduct linkdeco1" href="view_guest.htm">GUEST LIST</a>
		     	<a class="linkproduct linkdeco2" href="add_guest.jsp">ADD NEW GUEST</a>
		      	
		    
  		</div>
  	</div>	
  	<div class="col-6 col-s-9">
    <h1>THE TAJ PALACE</h1>
    <p>A hotel is an establishment that provides paid lodging on a short-term basis. ... 
    	Hotel rooms are usually numbered (or named in some smaller hotels and B&Bs) to allow guests to identify their room. Some boutique,
     high-end hotels have custom decorated rooms. Some hotels offer meals as part of a room and board arrangement.</p>
    </div>
    <div class="col-3 col-s-12">
    	<div class="aside">
      <h2>What?</h2>
      <p></p>
      <h2>Where?</h2>
      <p></p>
      <h2>How?</h2>
      <p></p>
    </div>
  </div>

	<div class="footer">
 		 <p>Resize the browser window to see how the content respond to the resizing.</p>
	</div>
  
</body>
</html>