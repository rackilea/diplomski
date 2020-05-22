//create employee objects first
    KNW_Employee emploee1 = new KNW_Employee();
    KNW_Employee emploee2 = new KNW_Employee();


    //Ask for employee's ID
    System.out.println("Enter ID for Employee 1: ");
    emp1 = input.nextInt();
    emploee1.setID(emp1);//set the id value for employee1
    System.out.println("Enter ID for Employee 2: ");
    emp2 = input.nextInt();
    emploee2.setID(emp2);//set the id value for employee2

    //Ask for employee's hours
     System.out.println("Enter Employee 1's Hours: ");
     hour1 = input.nextDouble();
     emploee1.setWeeklyHrs(hour1);
     System.out.println("Enter Employee 2's Hours: ");
     hour2 = input.nextDouble();
     emploee1.setWeeklyHrs(hour2);

     //Ask for employee's pay
     System.out.println("Enter Employee 1's Pay: ");
     pay1 = input.nextDouble();
      emploee1.setPayRate(pay1);
     System.out.println("Enter Employee 2's Pay: ");
     pay2 = input.nextDouble();
     emploee1.setPayRate(pay2);

   System.out.println(emploee1);//print employee1 (this calls toString())
   System.out.println(emploee2);//print employee2 (this calls toString())