package a.b.c;

interface <c:get select="$object/@interface"/> { 
<c:iterate select="$object/method" var="method" > 
    <c:get select="$method/@returns"/> <c:get select="$method/@name"/>(int x, int y);  
</c:iterate>
}