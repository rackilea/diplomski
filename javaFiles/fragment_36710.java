<c:if test="{not empty modelBeanCollection}">
      <c:forEach items="${modelBeanCollection}" var="project">
        <tr>
              <td>${project.getLastName}></td>
              <td>${project.getFirstName}></td>
              <td>${project.getAddress1}</td>
              ...
          </tr>
      </c:forEach>
    </c:if>