<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>List Customers</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>
<body>

<br>
<br>
	<div id="wrapper">
		<div id="header">
			
			<h2 style="text-align: center;">CRM - Content Management System</h2>
		</div>
		
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- put new button- add new customer  and here it will call the spring controller mapping.-->
			<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
			class= "add-button"
			/>
			
		<!-- Add out the html table here -->
		
			<table>
				<tr> 
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print out the customers -->
				<c:forEach var="tempCustomer" items="${customerscontrol}">
				
					<!-- construct an update link with CustomerID -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>
				<tr>
					<td>${tempCustomer.firstName}</td> <!-- tempCustomer will call getFirstName() -->
					<td>${tempCustomer.lastName} </td>
					<td>${tempCustomer.email}	 </td>	
					
					<td>
					<!-- displaying the link -->
					
					<a href="${updateLink}">Update</a>
					</td>
				</tr>
				
				</c:forEach>
				
			</table>
		</div>
	</div>
</body>
</html>