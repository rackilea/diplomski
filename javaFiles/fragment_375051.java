Query averageSalarySubq = pm.newQuery(Employee.class);
averageSalarySubq.setResult("avg(salary)");
averageSalarySubq.setFilter("this.department = :outerDepartment");

Query qry = pm.newQuery(Department.class);
qry.setFilter("averageSalary > 10000");
qry.declareVariables("double averageSalary");
qry.addSubquery(averageSalarySubq, "double averageSalary", null, "this");