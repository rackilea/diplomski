<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
...
<table>
<c:forEach items="${myModel}" var="${myContact}" varStatus="count">
    <tr>
        // I am setting the unique name for each input here
        <td><input type="text" name="name_${count.index}"/></td>
        <td>${myModel.name}</td>
      ........
    </tr>
</c:forEach>