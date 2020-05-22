<c:choose>
    <c:when test="${not empty ampApInfo.colourcd}">
        <ColourCd>${ampApInfo.colourcd}</ColourCd>
    </c:when>
    <c:when test="${not empty ampApInfo.szWeightColourcd}">
        <ColourCd>${ampApInfo.szWeightColourcd}</ColourCd>
    </c:when>
    <c:otherwise />
</c:choose>