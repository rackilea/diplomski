@Override
        public List<Employee> getAllEmployees(String employeeName) { 
        Session session = //initialize session            
        Query query = session.createQuery("FROM Employees e WHERE e.name like '%"+ ? + "%'");
           query.setParameter(0, "%"+employeeName+"%");
           List<Employee>  employees = query.list();
           System.out.println(employees);
           return employees;
        }