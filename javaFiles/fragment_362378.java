<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>${message }</h1>
<h2>${welcome }</h2>
<c:forEach items="${batches }" var="batch">  
    ${batch.id } - ${batch.name }
</c:forEach>