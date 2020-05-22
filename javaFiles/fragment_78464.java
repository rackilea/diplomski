public static void main(String[]args)
       {
         Student stud=new Student(); // call the default constructor, don't enter bogus data

          Scanner in = new Scanner(System.in);
          int x = choices();
          while (x != 7) {
          switch(x) {
            case 1:
             System.out.println("Enter Student ID:");
             stud.setID(in.nextInt());
             in.nextLine();
             System.out.println("Enter Student Name:");
             stud.setName(in.nextLine());
             System.out.println("Enter Student Course:");
             stud.setCourse(in.nextLine());
             System.out.println("Enter Student Level:");
             stud.setLevel(in.nextLine());
             break;
            case 2: stud.display(); break;
           }
          // this must be inside the loop!!
          x = choices();
       }
  }