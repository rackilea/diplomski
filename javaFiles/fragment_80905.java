<form action="/CommissionTool/submitrule" method="post" model="formRule">
...
<select name="rule.id"><c:forEach items="${listRules}" var="rule">
                                <option value="${rule.id}">
                                    <c:out value="${rule.id}" />
                                </option>
                </c:forEach>
            </select>