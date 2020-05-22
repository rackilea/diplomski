<c:forEach var="i" items="${first}" >
              <c:choose><c:when test="${second.contains(i)}">
                  <strong ><c:out value="${i}"/></strong>
              </c:when><c:otherwise>
                  <c:out value="${i}"/>
              </c:otherwise></c:choose>
          </c:forEach>