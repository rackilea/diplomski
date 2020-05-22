<c:set var="xmlString" value="${sessionScope.delitosXML }">

<x:parse xml="${xmlString}" var="xmlOutput"/>

<x:forEach select="$xmlOutput//catDelitoDTO" var="dto">
    <x:out select="$dto//catDelitoId"/>
    <x:out select="$dto//nombre"/>
</x:forEach>