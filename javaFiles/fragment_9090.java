<table id="example" class="table table-striped table-bordered table-hover" style="max-width: 85% !important;">
   <thead>
      <tr>
         <th><b>Requested By</b></th>
         <th><b>Request Type</b></th>
         <th><b>Reason</b></th>
         <th><b>Requested Date</b></th>
         <th><b>Status</b></th>
      </tr>
   </thead>
   <tbody>
      <tr th:each="request : ${requests}" th:if="${request.get('requestStatus') == 'Pending'}">
         <td th:text="${request.get('author').get('username')}" class="initial-name">Employee Initials</td>
         <td th:text="${request.get('requestType')}">Request Type</td>
         <td th:text="${request.get('requestText')}">Reason</td>
         <td th:text="${request.get('dateRequested')}">Requested Date</td>
         <td th:switch="${request.get('requestStatus')}">
            <th:block th:case="Pending" th:text="${request.get('requestStatus')}"><span class="red">Pending</span></th:block>
            <th:block th:case="Approved" th:text="${request.get('requestStatus')}"><span class="green">Approved</span></th:block>
            <th:block th:case="Rejected" th:text="${request.get('requestStatus')}"><span class="red">Rejected</span></th:block>
         </td>
      </tr>
   </tbody>
</table>