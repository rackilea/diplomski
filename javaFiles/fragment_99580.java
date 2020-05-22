<!-- Fragment -->
<form th:fragment="userform (action)" th:action="@{${action}}">
  .
  .
  .
</form>

<!-- Including the fragment -->
<div th:replace="fragments/userform :: userform(action='/admin/new-user-form')" />
<!-- or -->
<div th:replace="fragments/userform :: userform(action='/moderator/new-user-form')" />