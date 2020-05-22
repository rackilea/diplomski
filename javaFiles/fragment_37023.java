Map routings = (Map)resultMap.get("routings");

    // lets iterate every routing in routings
    for(Object routingKey : routings.keySet()){

        Map routing = (Map)routings.get(routingKey);
        Map tableData = (Map)routing.get("sourcetables-data");

        List employeeList = (List)tableData.get("Employee");
        //lets print all names of Employee
        for(Object item : employeeList){
           Map field = (Map)item;
           Object name = field.get("name");
           Object value = field.get(name);
           System.out.println(name+"="+value);
        }
    }