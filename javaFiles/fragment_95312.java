<c:choose>
  <c:when test="${orderUploadAction.errors.size()==0}">
     <script> yourFunctionName() </script>
  </c:when>
  <c:otherwise>
     <script> yourAnotherFunctionName() </script>
  </c:otherwise>
</c:choose>