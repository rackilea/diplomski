<textarea id="myContent${status.index}" name="myContents"
    <c:if test="${checkedCodeMap[checkCode.codValue].category.codId ne myCode.codId}">disabeld="disabled"</c:if>>
          <c:if test="${checkedCodeMap[checkCode.codValue].category.codId ne myCode.codId}">
${checkedCodeMap[checkCode.codValue].content}
          </c:if>
    </textarea>