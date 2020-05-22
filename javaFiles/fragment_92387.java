SQLQuery query = session.createSQLQuery("select e.id as eid , r.id as rid , e.ename , e.enumber , r.description from employee_profile e  INNER JOIN role r ON (e.role_id = r.id)"); 

 List <Object []> rows =query.list();
 List <Employee> employee_role = new ArralList<>();
for(Object[] row : rows){
    Employee emp = new Employee();
    Role role = new Role();

    emp.setId(Integer.parseInteger(row[0].toString()));
    role.setId(Integer.parseInteger(row[1].toString()));
    emp.setEname(row[2].toString());
    emp.setEnumber(row[3].toString()));
    role.setDescription(row[4].toString()));
    emp.setRole(role);


    employee_role.add(emp);
    }
 return employee_role;