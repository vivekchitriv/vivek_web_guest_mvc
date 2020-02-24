<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
   <%@page import="java.util.*" %>
<%@page import="java.lang.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Add Guest</title>
		
</head>
<body style="text-align: center">
<h1><u>ADD GUEST</u></h1>
${result}
<form action="add" method="post">

            <table>
                <tr>
                    <th>Guest Id</th>
                    <th>Guest Name</th>
                    <th>Address</th>
                    <th>Id Type</th>
                    <th>Id Number</th>
                    <th>Mobile Number</th>
                 </tr>
                <tr>
                    <td><input class="input_deco"  type="text"placeholder="Guest id" name="gId" readonly="readonly"value="<% out.print("TAJ"+getSaltString()); %>" ></td>
                    <td><input class="input_deco" type="text" placeholder="Guest Name" name="gName"></td>
                    <td><input class="input_deco" type="text" placeholder="Address" name="addrs"></td>
                    <td><select name ="IdType">
									<option value="adh">ADDHAR</option>
									<option value="pan">PAN</option>
									<option value="voting">VOTER</option>
									<option value="rasan">RASAN</option>
								</select> 
					</td>
                    <td><input class="input_deco"  type="text" placeholder="Id Number(addhar,pan,voter)" name="idNum"></td>
                	<td><input class="input_deco"  type="text" placeholder="Mobile number" name="mob"></td>
                	</tr>
                <tr>
                    <td colspan="6"> <button class="btn_deco" type="submit">Submit</button></td>
                </tr>
            </table>

        </form>
       
</body>
</html>
 <%!
public static String getSaltString() {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    while (salt.length() < 6) { // length of the random string.
        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr;

}

%>