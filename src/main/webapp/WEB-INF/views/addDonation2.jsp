<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>

<div>
    <div>Podaj liczbę 60l worków, w któe spakowałeś/aś rzeczy</div>
    <form:form method="post" modelAttribute="donationPart2">
        <label for="quantity">Number of weeks in plan:</label>
        <form:input type="number" value = "${donation.quantity}" path="quantity" id="quantity"/>
<br>

        <input type="submit" value="Potwierdź ilość">

        </form:form>
</div>


<script src="<c:url value="resources/js/app.js"/>"></script>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>

</body>
</html>
