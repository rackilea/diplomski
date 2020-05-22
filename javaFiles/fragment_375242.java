<select class="form-control">
            <c:choose>
                  <c:when test='${staff.staffFruit == "Apple"}'>
                    <option selected>Apple</option>
                  </c:when>
                <c:otherwise>
                  <option>Apple</option>
                </c:otherwise>
            </c:choose>
            <c:choose>
                  <c:when test='${staff.staffFruit == "Orange"}'>
                    <option selected>Orange</option>
                  </c:when>
                <c:otherwise>
                  <option>Orange</option>
                </c:otherwise>
            </c:choose>
            <c:choose>
                  <c:when test='${staff.staffFruit == "Durian"}'>
                    <option selected>Durian</option>
                  </c:when>
                <c:otherwise>
                  <option>Durian</option>
                </c:otherwise>
            </c:choose>
            </select>