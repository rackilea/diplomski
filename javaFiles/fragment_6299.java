ObjectMapper mapper = new ObjectMapper();
    JsonNode rootNode = mapper.readTree(str);
    JsonNode empDetNode = rootNode.path("employeeDetail");
    Iterator<JsonNode> elements = empDetNode.elements();
    List<Employee> empList = new ArrayList<Employee>();
    Gson gson = new Gson();
    while (elements.hasNext()) {
        Employee emp1 = new Employee(); 
        JsonNode emp= elements.next();
        JsonNode empl= emp.path("employee");
        JsonNode name= empl.path("name");
        JsonNode age= empl.path("age");
        JsonNode details= empl.path("details");
        JsonNode role= details.path("details");
        emp1.setAge(age.toString());
        emp1.setName(name.toString());
        emp1.setRole(role.toString());
        empList.add(emp1);
    }
    EmpDetl empdetl = new EmpDetl();
    empdetl.setEmployeeDetl(empList);