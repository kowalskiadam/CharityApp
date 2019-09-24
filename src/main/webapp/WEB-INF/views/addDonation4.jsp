<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>

<div>
    <div>Dane adresowe</div>
    <form:form method="post" modelAttribute="donationPart4">
        <form:input path="zipCode" />        <br>

        <form:input path="street" />        <br>

        <form:input path="city"/>        <br>

        <form:textarea path="pickUpComment"/>        <br>

        <form:input type="date" path="pickUpDate"/>        <br>

        <form:input type="time" path="pickUpTime" />        <br>


        <br>
        <input type="submit" value="Wybierz instytucję">
    </form:form>

</div>



<script src="<c:url value="resources/js/app.js"/>"></script>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>

</body>
</html>
