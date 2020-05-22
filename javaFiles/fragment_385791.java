Query query = session.getNamedQuery("SQLQuery");
    List empList=new ArrayList();
    for (int i = 0; i < empList.size(); i++) {                  
    Employee emp = (Employee) empList.get(i);
    System.out.println("Employee Code:::" + emp.getEmpcode());
   System.out.println("Employee Name:::" + emp.getEmpname());

//I want to get here System.out.println("Employee Count");
   System.out.println("Employee Count:::" + empList.size());
}