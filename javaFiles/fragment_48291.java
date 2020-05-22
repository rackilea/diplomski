<select name="ref_name">
    <c:forEach var="aff" items="${obj.connect()}" >
        <c:forEach var="secondVar" items="${aff}" >
            <option value="${secondVar}">${secondVar}</option> // printing the value here
        </c:forEach>
    </c:forEach>
 </select>