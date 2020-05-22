for(int i = 0; i < 10; i++)
    {
    //ask to input details
    System.out.println("-------------------------------------------------");
    System.out.println("Please input the information below:");
    System.out.println("-------------------------------------------------");
    System.out.println("Please input the student's name : ");
    name = scan.nextLine();
    System.out.println("Please input the student's number : ");
    number = scan.nextLine();
    System.out.println("Please input the student's course code : ");
    courseCode = scan.nextLine();
    System.out.println("Please input the student's course entry year : ");
    entryYear = scan.nextInt();
    scan.nextLine();

    System.out.println("Please input the order you want to put Student in the List
    [1 for Sorted and any other number to add at the end of this list ] : ");
    order = scan.nextInt();

    s1 = new Student(name, number, courseCode, entryYear); //create new student

    if(order == 1){
    list.sorted(s1);
    } else {
    list.add(s1); //add s1 to list
    }
}