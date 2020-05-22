<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:forEach items="${preferences.preferenceList}" var="preference" varStatus="itemRow">
    <c:set var="varPath" value="preferenceList[${itemRow.index}]"/>
    <tr height="35px" bgcolor="#fafafa" bordercolor="#FFF">
        <td width="50%">
            <form:label path="${varPath}.preferenceName">${preference.preferenceName}</form:label>
        </td>
        <td width="20%">
            <c:if test="${preference.preferenceType=='boolean'}">
                <form:radiobutton path="${varPath}.preferenceValue" value="true">Yes</form:radiobutton>
                <form:radiobutton path="${varPath}.preferenceValue" value="false">No</form:radiobutton>
            </c:if>
        </td>
    </tr>
</c:forEach>