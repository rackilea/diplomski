<c:forEach var="recipe" items='${recipes}' varStatus="recipeCounter">
  <c:if test="${recipeCounter.count > (totalRecipes - 3)}">
    <div class="span4">
      <h3<c:out value="${recipe.inputDescProb}"></c:out></h3>
      <p><c:out value="${recipe.inputDescSol}"></c:out></p>
      <p><a class="btn" href="/recipes/${recipe.id}">Details &raquo;</a></p>
    </div>
  </c:if>
</c:forEach>