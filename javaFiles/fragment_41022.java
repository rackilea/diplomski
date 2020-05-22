private void doAddStudent()
    {
        String addMore;
        do
        {
            System.out.println("\nAdd New Student\n***********\n");

            try
            {
                System.out.println("Enter Students Forename :>");
                String fName = input.next();//use next() instead of nextLine()

                System.out.println("Enter Student Surname :>");
                String sName = input.next();//use next() instead of nextLine();

                System.out.println("Enter Student ID Number :>");
                int idNum = input.nextInt();

                theRegistry.addStudent(new Student(fName, sName, idNum));

            } catch (Exception e)
            {
                System.out.println("\nERROR OCCURED: Incorect Value Entered"
                        + "\nTry Again... \nStudent Was NOT added");
            }


            System.out.println("\nAdd Another Student (Y/N) : >");
            addMore = input.next();



        } while (!"n".equals(addMore));
    }