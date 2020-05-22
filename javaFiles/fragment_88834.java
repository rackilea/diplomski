<ol>
  <!--/*/ <th:block th:each="dept : ${departmentList} "> /*/-->

   <li th:each="emp : dept.employees" th:text="|${emp.name} from ${dept.name}|"></li>

  ￼<!--/*/ </th:block> /*/-->
</ol>