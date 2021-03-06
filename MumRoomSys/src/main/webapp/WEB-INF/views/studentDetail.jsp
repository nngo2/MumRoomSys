<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h5>Student Details</h5>
<hr/>
<form:form modelAttribute="student" action="/student/create" method="post">
	<fieldset>
		<div class="form-group">
			<label for="name">Name</label> 
			<form:input path="name" id="name" class="form-control" placeholder="Name"/>
			<form:errors path="name" cssClass="error"/>
		</div>	
		<div class="form-group">
			<label for="email">Email</label> 
			<form:input type="email" path="email" id="email" class="form-control" placeholder="Email"/>
			<form:errors path="email" cssClass="error"/>			
		</div>					
		<div class="form-group">
			<label for="phone">Phone</label> 
			<form:input type="text" path="phone" id="phone" class="form-control" placeholder="123-456-7890"/>
			<form:errors path="phone" cssClass="error"/>			
		</div>	
	</fieldset>
	<fieldset>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label for="username">Login</label> 
				<form:input type="text" path="username" id="username" class="form-control" />
				<form:errors path="username" cssClass="error"/>
			</div>		
			<div class="form-group col-md-6">
				<label for="password">Password</label> 
				<form:password path="password" id="password" class="form-control"/>
				<form:errors path="password" cssClass="error"/>				
			</div>				
		</div>
		<div class="form-group">
			<label for="role">Role</label> 
		 	<form:select path="role" class="form-control" id="role">
				<form:option value="STUDENT">Student</form:option>				 	
				<form:option value="DIRECTOR">Director</form:option>
			</form:select>
			<form:errors path="role" cssClass="error"/>			
	 	</div>		
		<div class="form-check">
			<form:checkbox class="form-check-input" path="enabled" id="enabled" />
			<label class="form-check-label" for="enabled">Enabled</label> 
			<form:errors path="enabled" cssClass="error"/>			
		</div>										
	</fieldset>
	<fieldset>
		<form:button type="submit" class="btn btn-primary" value="submit">Submit</form:button>
	</fieldset>
</form:form>