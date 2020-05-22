public List<Employee> getItems() {
   Map<String, String> mapObj = new HashMap<String, String>();
            for (Employee employee: 
                 myDAO.getEmployeeDetails()) {
                map.put(employeeLabel.getEmployeeGroup(),
                         employeeLabel.getEmployeeGroupDescription());
            }
 }

JSP:
//Don't forget to add the mapObj to the request context
<select id="emp">
        <c:forEach var="item" items="${mapObj}">
            <option value="${item.key}">${item.value}</option>
        </c:forEach>
    </select>