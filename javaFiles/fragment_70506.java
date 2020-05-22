logger.debug("Update method dao :");
Employee emp = form.getEmployee();
Employee employee = manager.find(Employee.class, emp.getID());

Field[] empField = emp.getClass().getDeclaredFields();
Field[] employeeField = employee.getClass().getDeclaredFields();

for (int i = 0; i < empField.length; i++) {
 empField[i].setAccessible(true);
 employeeField[i].setAccessible(true);

 try {
  if (empField[i].get(emp) != null && !empField[i].get(emp).equals(employeeField[i].get(employee))) {
   employeeField[i].set(employee, empField[i].get(emp));
  }
 } catch (IllegalArgumentException e) {
  e.printStackTrace();
 } catch (IllegalAccessException e) {
  e.printStackTrace();
 }

}

employee.setUser(form.getUser());
manager.merge(employee);
manager.flush();
}