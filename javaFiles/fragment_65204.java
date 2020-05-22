<tbody id="myTable">
    <c:choose>
        <c:when test="${data.size() > 0 }">
            <c:forEach var="emp" items="${data}">
                <tr align="center">
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.designation}</td>
                    <td><a href="editemp/${emp.id}" class="btn btn-outline-info">Edit</a></td>
                    <td><a href="deleteemp/${emp.id}" class="btn btn-outline-danger">Delete</a></td>
                </tr>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <tr align="center">
                <td colspan="5">No Users available</td>
            </tr>
        </c:otherwise>
    </c:choose>

    <c:if test="${data.size() > 0 }">
        <div class="panel-footer">
            Showing ${number+1} of ${size+1} of ${totalElements}
            <ul class="pagination">
                <c:forEach begin="0" end="${totalPages-1}" var="page">
                    <li class="page-item">
                        <a href="viewemp?page=${page}&size=${size}" class="page-link">${page+1}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

</tbody>