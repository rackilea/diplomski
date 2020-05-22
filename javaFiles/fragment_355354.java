Scanner scanner = new Scanner(System.in);

    //Input the term
    System.out.println("Please enter the term of your grade calculation (for example, Fall 2015): ");
    String term = scanner.nextLine();

    //Input the number of courses that the student is enrolled in
    System.out.println("Please enter the number of courses that you are enrolled in "+term+": ");
    int numberofcourses = scanner.nextInt();
    scanner.nextLine();

    //Declaration
    String a[] = new String[numberofcourses];

    //Arrays for class number, description, units, grade, grades point
    //Here, input class number, description, units, and grades
    for(int i = 0; i < numberofcourses; i++)
    {
        System.out.println("Please enter the #"+(i+1)+" class name: ");
        String ClassName = scanner.nextLine();

        System.out.println("Please enter the #"+(i+1)+" description: ");
        String Description = scanner.nextLine();

        System.out.println("Please enter the #"+(i+1)+" units: ");
        int Units = scanner.nextInt();

        System.out.println("Please enter the #"+(i+1)+" grades: ");
        int Grades = scanner.nextInt();

        System.out.println("Class Grades - "+term+" Term");
        System.out.println("Office Grades");
        System.out.println(String.format("Class: %s Description: %s Units: %d Grade: %d Grade Points", ClassName, Description, Units, Grades));
    }