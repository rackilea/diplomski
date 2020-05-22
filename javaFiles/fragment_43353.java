<c:choose>
    <c:when test="${empty example1}"> 
        <!-- do stuff -->
    </c:when> 
    <c:otherwise> 
        <c:choose>
            <c:when test="${empty example2}"> 
                <!-- do different stuff -->
            </c:when> 
            <c:otherwise> 
                <!-- do default stuff -->
            </c:otherwise>
        </c:choose>
    </c:otherwise> 
</c:choose>