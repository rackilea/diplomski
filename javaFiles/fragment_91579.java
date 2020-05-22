Employee emp=new Employee();
            Address address=new Address("your address");
            emp.setAddress(address);
            emp.setId(1);
            emp.setEmployeeReferenceId("CP001");
            emp.setEmployeeName("Muthu");
            emp.setEmployeeDesg("Developer");
            emp.setSalary("15000");
            session.update(emp);