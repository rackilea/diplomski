<%-- Set scoped variables --%>
    <c:set var="para" value="${41+1}" scope="page" />
    <c:set var="para" value="${41+1}" scope="request" />
    <c:set var="para" value="${41+1}" scope="session" />
    <c:set var="para" value="${41+1}" scope="application" />

    <%-- Print the values --%>
    <c:out value="${pageScope.para}" />
    <c:out value="${requestScope.para}" />
    <c:out value="${sessionScope.para}" />
    <c:out value="${applicationScope.para}" />