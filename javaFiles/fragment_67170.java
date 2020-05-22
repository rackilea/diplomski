<s:iterator value="resulttypelist" var="result">
    <s:if test="%{#result.resultTypeId == #attr.row.resultTypeId}">
        <option value="${result.resultTypeId}" selected="selected">${result.resultTypeName}</option>
    </s:if>
    <s:else>
        <option value="${result.resultTypeId}">233${result.resultTypeName}</option>
    </s:else>
</s:iterator>