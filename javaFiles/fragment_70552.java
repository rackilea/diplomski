<c:if test="${message.message != null}">
    <div class="msg">test1: ${message.message}</div>
</c:if>
<c:if test="${message.message != ''}">
    <div class="msg">test2: ${message.message}</div>
</c:if>