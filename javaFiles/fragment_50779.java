<c:forEach var="route_desc" items="${routes}">
                        <option value="${route_desc.key}">
                        <c:if test="${not empty route_desc}">
                             <c:out value="${route_desc.value}" />   
                        </c:if> 
                        </option>
                    </c:forEach>