private Employee prepareModel(EmployeeBean employeeBean) {
        Employee employee = new Employee();
        employee.setEmpAddress(employeeBean.getAddress());
        employee.setEmpAge(employeeBean.getAge());
        employee.setEmpName(employeeBean.getName());
        employee.setSalary(employeeBean.getSalary());
        employee.setEmpId(employeeBean.getId());
        return employee;