class Phone {
...
   void setEmployee(Employee employee) {
      owner = employee;
      employee.addPhone(phone);
   }
...
}