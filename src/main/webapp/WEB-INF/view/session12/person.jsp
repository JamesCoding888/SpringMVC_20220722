<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spform" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@2.1.0/build/pure-min.css"> 
	<meta charset="UTF-8">
	<title>Person Form</title>
	<style type="text/css">
		.error{
			color: #FF0000
		}
	</style>
</head>
<body style="padding: 15px;">
	<spform:form class="pure-form"
									method="post"
									modelAttribute="person"
					 				action="${ pageContext.request.contextPath }/mvc/person/">
		<fieldset>
			<legend>Person form</legend>
			Name:	<spform:input path="name"/>
							<spform:errors path="name" cssClass="error" /><p />
			Age:		<spform:input path="age" type="number"/>
							<spform:errors path="age" cssClass="error" /><p />
			Member:	<spform:radiobutton path="member" value="true"/>Member
								<spform:radiobutton path="member" value="false"/>Non-Member
								<spform:errors path="member" cssClass="error" /><p />
			Birthday:	<spform:input path="birth" type="date"/>
							<spform:errors path="birth" cssClass="error" /><p />
			<button type="submit" class="pure-button pure-button-primary">Create</button>
			<spform:errors path="*" cssClass="error" /><p />
		</fieldset>
		
	</spform:form>
	${ people }


</body>
</html>