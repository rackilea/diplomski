public Employee searchByName(String name) 
{
    Employee employee = map.get(name);    
    System.out.println(employee.toString());
    return employee;
}