<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
    <c:forEach begin="1" end="10" varStatus="status">
        <tr>
            <td><c:forEach begin="1" end="${status.index}">
                        ${param.name}&nbsp;
                    </c:forEach> Value of k: ${status.index}</td>
        </tr>
    </c:forEach>
</table>