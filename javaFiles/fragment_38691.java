Scanner in = new Scanner(System.in);
    System.out.println("Enter array size");
    int size = in.nextInt();
    Subject[] subjects = new Subject[size];
    String name;
    Double grade;
    Subject object;
    for(int i =0; i<size; i++)
    {
        System.out.println("Enter Subject name: ");
        name=in.next();
        System.out.println("Enter Subject Grade: ");
        grade = in.nextDouble();
        object = new Subject(name,grade);
        subjects[i] = object;
    }
    for(int i=0; i<size; i++)
        System.out.println("Subject name is "+subjects[i].name + " Grade is "+subjects[i].grade);
}