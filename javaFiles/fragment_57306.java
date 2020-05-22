public static void selectEMployee() {

  if (list1!=null && !list1.isEmpty()) {
      System.out.println("The list of employees are");

      for (Employee emp : list1) {
           System.out.println("Name::" + emp.getName() + "\t EmpId::"
            + emp.getEmpid() + "\t Address::" + emp.getAddress()
            + "\tphone::" + emp.getPhone());
      }

  } else {
      System.out.println("The list is empty");
  }
}