<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<body>
<%@ include file="/WEB-INF/fragments/header.jspf" %>

<div class="form--steps">
    <h2>addDonation1</h2>
        <div class="form--steps-container" >
            <div class="form-group--checkbox">
                <form:form method="post" modelAttribute="donationPart1">
                    <form:checkboxes items="${allCategories}" path="categories"  itemLabel="name" itemValue="id" />
                    <input type="submit" value="Wybierz kategorię">

                </form:form>
            </div>

        </div>

</div>


<script src="<c:url value="resources/js/app.js"/>"></script>
<%@ include file="/WEB-INF/fragments/footer.jspf" %>

</body>
</html>
