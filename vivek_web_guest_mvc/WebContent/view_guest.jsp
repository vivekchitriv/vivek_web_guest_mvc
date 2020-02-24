<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>View Guest</title>
</head>
<body style="text-align: center">
	<a class="linkproduct linkdeco1" href="home">HOME</a>
    <a class="linkproduct linkdeco1" href="add_guest">Add Product</a>
    <c:choose>
    	<c:when test="${!empty result}">
    		<h5>${result}</h5>
    	</c:when>
    </c:choose>
        <h1><u>View Guest</u></h1>
        
        <c:choose>
	<c:when test="${!empty guest}">
		<table>
	        <tr>
	            <th>SNO</th>
	            <th>Guest ID</th>
	            <th>Guest Name</th>
	            <th>address</th>
	            <th>ID Type</th>
	            <th>ID Number</th>
	            <th>Mobile</th>
	            <th>Check In</th>
	            <th>Check Out</th>
	            
	            <th colspan="1">EDIT</th>
	            <th colspan="1">CheckOut</th>
	        </tr>
	        <c:forEach var="dto" items="${guest}">
		        <tr>
		            <td>${dto.sNo}</td>
		            <td>${dto.guestId}</td>
		            <td>${dto.name}</td>
		            <td>${dto.address}</td>
		            <td>${dto.idType}</td>
		            <td>${dto.idNumber}</td>
		            <td>${dto.mob}</td>
		            <td>${dto.checkIn}</td>
		            <td>${dto.checkOut}</td>
		            
		             <td><a href="edit_guest?id=${dto.sNo}"><img class="img_prop" title="Click to Edit" src="assets/plan.svg" alt=""></a></td>
		            <td><a href="check_out?id=${dto.sNo}"><img class="img_prop" title="Click to checkout"src="assets/plan.svg" alt=""></a></td>
		        </tr>
	        
	        </c:forEach>
	        
	    </table>
	
	</c:when>
	<c:otherwise><h5>No data found</h5></c:otherwise>



</c:choose>
</body>
</html>