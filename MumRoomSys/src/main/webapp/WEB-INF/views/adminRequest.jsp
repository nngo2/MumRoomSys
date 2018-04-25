<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<table class="tablerequest">
	<tr><th>Student name</th><th>Request type</th><th>Request Description</th></tr>
	<c:forEach var="request" items="${requests.getContent()}">
			<tr >
				<td >${request.student.name}</td>
				<td>${request.type}</td>	
				<td>${request.description}</td>	
				<td><button>edit</button></td>
				<td><button>delete</button>	</td>
			</tr>								
	</c:forEach> 	
</table>	
<table class="table table-hover table-striped">
	<thead class="thead-dark">
		<c:url var="post_url" value="/request/selectRequest/0" />
		<form:form class="form-inline my-2 my-lg-0" 
			modelAttribute="request" action="${post_url}" method="post">
			<div class="form-row">
			 	<div class="form-group col-md-4">
				 	<form:select path="description" class="form-control">
						<form:option value="BY REQUEST TYPE">Request Type</form:option>				 	
						<form:option value="BY BUILDING">By building</form:option>
						<form:option value="BY STUDENT">By student Id</form:option>
					</form:select>
					<form:button  type="submit">list out </form:button>			 	
			 	</div>
			</div>
		</form:form>	
	</thead>
</table>