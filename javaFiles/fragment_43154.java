public List getEmployeeTasks(){

    Transaction tx = this.session.beginTransaction();

    List<Employee> employeeTaskList = null;

    try{
       session.beginTransaction();
      Query query = session.createQuery("select e.name, t.description from Employee as e, Role as r, Task as t, EmployeeTask as et where e.employeeid=r.employeeid and t.taskid=et.taskid and e.employeeid=et.employeeid");
        List<Object[]> result = (List<Object[]>) query.list();

    if (null != result && result.size() != 0) {

            for (Object[] obj : result) {
                //Set values over here 
                employeeTaskList.set.....
            }
        tx.commit();
    }
    }
    catch(HibernateException ex){
        ex.printStackTrace();
        tx.rollback();
    }
    return employeeTaskList;
}