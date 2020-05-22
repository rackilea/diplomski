<select>  
    <c:forEach var="item" items="${statuses}">  
        <c:choose>
            <c:when test="${cur.status == item}">
                <option selected>${item}</option>
            </c:when>
            <c:otherwise>
                <option>${item}</option>
            </c:otherwise>
        </c:choose>
    </c:forEach>  
</select>