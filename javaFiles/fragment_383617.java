request.setAttribute("myMap", map);   

<c:forEach items="${myMap}" var="mapEntry">
     key : ${mapEntry.key} 
     <c:forEach items="${mapEntry.value}" var="item">
        Category :  ${item.category}
     </c:forEach><br>
 <c:forEach>