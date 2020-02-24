<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Edit Guest</title>
</head>
<body style="text-align: center">
		 <h1><U>Edit Guest</U></h1>
		 <a class="linkproduct linkdeco1" href="home">HOME</a>
         <a class="linkproduct linkdeco1" href="view_guest">View Guest</a>
         <form action="edit" method="post">

            <table>
                <tr>
                	<th>SNO</th>
                    <th>Name</th>
               		<th>Address</th>
               		<th>Id Type</th>
                    <th>Id Number</th>
                    <th>Mobile Number</th>
                </tr>
                <tr>
                	<td><input class="input_deco" readonly type="text"  value="${dto.sNo}" placeholder="sno" name ="gNo"></td>
                    <td><input class="input_deco" type="text" value="${dto.name}"  name="gName"></td>
                    <td><input class="input_deco" type="text" value="${dto.address}" placeholder="Address" name="addrs"></td>
                    <td><select value="${dto.idType}" name ="IdType">
									<option value="adh">ADDHAR</option>
									<option value="pan">PAN</option>
									<option value="voting">VOTER</option>
									<option value="rasan">RASAN</option>
								</select> 
					</td>
                    <td><input class="input_deco"  type="text" value="${dto.idNumber}" placeholder="Id Number(addhar,pan,voter)" name="idNum"></td>
                	<td><input class="input_deco"  type="text" value="${dto.mob}" name="mob"></td>
                </tr>
                <tr>
                    <td colspan="6"> <button class="btn_deco" type="submit">Update</button></td>
                </tr>
            </table>

        </form>
</body>
</html>