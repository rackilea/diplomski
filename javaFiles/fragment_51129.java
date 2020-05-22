String studId = "";
String firstName ="";
String lastName ="";
int number =0;
int index = 0;
StudentServiceImpl studServImpl = new StudentServiceImpl();
Scanner scan = new Scanner(System.in);

do{

System.out.println("1.Add Student:");
System.out.println("2.Delete Student:");
System.out.println("3.Display Students:");
System.out.println("4.Exit");
System.out.println();
System.out.print("Select number: ");
System.out.println();
number=scan.nextInt();

if(number==1){
    Student student =  new Student();
    System.out.println("Enter Student No.");
    studId = scan.next();
    student.setStudId(studId);

    System.out.println("Enter First Name:");
    firstName = scan.next();
    student.setFirstName(firstName);

    System.out.println("Enter Last Name:");
    lastName = scan.next();
    student.setLastName(lastName);

    studServImpl.add(student);

}


    else if(number ==2){



    }

    else if (number == 3){

    List<Student> studentList = new ArrayList<Student>();

    studentList = studServImpl.getStudent();

    System.out.println("\nThe size of List: "+studentList.size());



    for (Student studentRec : studentList) {
        System.out.println("Student ID: "+ studentRec.getStudId());
        System.out.println("First Name: "+ studentRec.getFirstName());
        System.out.println("Last Name: "+ studentRec.getLastName()+"\n");


    }

    }

    else if(number == 4){

        System.out.println("Thank you, Good Bye!");
    }



    }


    while(number!=0);

}