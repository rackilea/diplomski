<th:block th:fragment="person">
  Name:<input type="text" th:field="*{__${prefix + 'name'}__}" /> 
  Surname:<input type="text" th:field="*{__${prefix + 'surname'}__}" />
</th:block>

<th:block th:fragment="application">
  Reason:<input type="text" th:field="*{__${prefix + 'reason'}__}" /> 
  Date:<input type="text" th:field="*{__${prefix + 'date'}__}" />
  <div th:replace="fragments/forms :: person" th:with="prefix=${prefix +'person.'}">
</th:block>