@Override
        public List<Employee> getAllEmployees(String employeeName) { 
            String query = "SELECT e.* FROM Employees e WHERE e.name like '%"+ employeeName +"%'";
            List<Object[]> employeeObjects = hibernateUtil.fetchAll(query);
            List<Employee> employees = new ArrayList<Employee>();
            for(Object[] employeeObject: employeeObjects) {
                Employee employee = new Employee();
                long id = ((BigInteger) employeeObject[0]).longValue();
                String name = (String) employeeObject[1];
                int age = (int) employeeObject[2];
                int admin = (int) employeeObject[3];
                boolean isAdmin=false;
                if(admin==1)
                isAdmin=true;
                Date createdDate = (Date) employeeObject[4];
                employee.setId(id);
                employee.setName(name);
                employee.setAge(age);
                employee.setAdmin(isAdmin);
                employee.setCreatedDate(createdDate);
                employees.add(employee);
            }
            System.out.println(employees);
            return employees;
        }