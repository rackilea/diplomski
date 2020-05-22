// creat an ArrayList of the object
    ArrayList<Student> studentList = new ArrayList<Student>();

    // then, ask if the user wants to add object
    Scanner in = new Scanner (System.in);
    System.out.print("Would you like to add an object?");

    while (true) {
        String ans = in.nextLine();
        if (ans.equals("no")) 
        {
            break;
        }
        // else, create the object and add it to the ArrayList
        // you can add the attributes from the constructor
        studentList.add(new Student(22, "name"));
    }