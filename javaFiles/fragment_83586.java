public void addEmployeeName(int num,ArrayList<Employee> lst) {



    for(int i =0; i<num ; i++)
    {
         Employee em = new Employee();
        System.out.println("Enter the employee id : ");
        em.setEmployeeId(sc.nextInt());

        System.out.println("Enter the name of employee : ");
        em.setName(sc.next());

        System.out.println("Enter the designation of employee : ");
        em.setDesignation(sc.next());

        System.out.println("Enter the Salary of employees : ");
        em.setSalary(sc.nextInt());

        lst.add(em);        
    }

    System.out.println(lst);
}

  }