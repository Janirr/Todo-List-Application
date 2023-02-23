<%--suppress ALL --%>
<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">

        <fieldset class="mb-2">
        <form:label path="description">Description</form:label>
        <form:input type="text" path="description" required="required"></form:input>
        <form:errors path="description" cssClass="text-warning" />
        </fieldset>

        <fieldset class="mb-2">
            <form:label path="description">Target Date</form:label>
            <form:input type="text" path="targetDate" required="required"></form:input>
            <form:errors path="targetDate" cssClass="text-warning" />
        </fieldset>

        <form:input type="hidden" path="id"></form:input>
        <form:input type="hidden" path="done"></form:input>

        <input type="submit" class="btn btn-success">
    </form:form>
</div>
<script type="application/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
    });
</script>
<%@include file="common/footer.jspf"%>
