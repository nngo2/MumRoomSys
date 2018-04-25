<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="requestform">
	<c:url var="post_url" value="/request/creatrequest" />
	<form:form modelAttribute="request" action="${post_url}" method="post">
   RequestType:<br>
		<form:select path="type" name="type">
			<form:option value="MAINTENANCE">Maintenance</form:option>
			<form:option value="CHANGING_ROOM">Changing Room</form:option>
			<form:option value="LEAVING_ROOM">Leaving Room</form:option>
		</form:select>
		<div>
			Request Description:<br>
			<form:input path="description" type="text" name="description" />
		</div>
		<input type="submit" value="Submit" />
		<br>
		<br>
	</form:form>
</div>

<table class="tablerequest">
	<tr>
		<th>Student name</th>
		<th>Request type</th>
		<th>Request Description</th>
	</tr>
	<c:forEach var="request" items="${requests.getContent()}">
		<tr>
			<td>${request.student.name}</td>
			<td>${request.type}</td>
			<td>${request.description}</td>
		</tr>
	</c:forEach>
</table>


