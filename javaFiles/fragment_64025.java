<c:forEach items="${cookie}" var="currentCookie">  
    Cookie name as map entry key: ${currentCookie.key}<br/>
    Cookie object as map entry value: ${currentCookie.value}<br/>
    Name property of Cookie object: ${currentCookie.value.name}<br/>
    Value property of Cookie object: ${currentCookie.value.value}<br/>
</c:forEach>