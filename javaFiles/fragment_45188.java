public void addEmployee(Employee emp) throws Exception {
    if (eme.size() == 0) {                          // add as list is empty
        eme.add(emp);
    } else {
        for (Employee e : eme) {                    // your logic as it is
            if (e.getEmpId() == emp.getEmpId()) {
                throw new Exception();
            } else if (e.getEmpId() != emp.getEmpId()) {
                eme.add(emp);
            }
        }
    }
}