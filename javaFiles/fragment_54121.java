public void deleteEmployee(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(emp);
        logger.debug(emp.getClass());
    }

public void updateEmployee(Employee emp) {
        Session session = sessionFactory.getCurrentSession();
        session.update(emp);
        logger.debug(emp.getClass());
    }

public List<Employee> getAllEmployee(){  
  String query ="SELECT e FROM EMPLOYEE e";
  List<Employee> empList = session.createQuery(query);     
  return empList;
}