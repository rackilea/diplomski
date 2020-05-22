while (choice != 2) {
       System.out.println("Enter Friend's Name: ");
       String name = input.next();
       System.out.println("Enter Friend's Age: ");
       String age= input.nextInt();
       Friends f = new Friends(name, age);
       friends.add(f);
       System.out.println("Enter another? 1: Yes, 2: No");
       choice = input.nextInt();
  }