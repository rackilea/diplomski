Person[] Arr = new Person[choice];
    for(ctr=0; ctr<choice; ctr++){
        System.out.print("First name:");
        String fname = scan.next();
        System.out.print("Last name:");
        String lname = scan.next();
        System.out.print("Age:");
        byte age = scan.nextByte();

        Person p1 = new Person(fname, lname, age);
        Arr[ctr] = p1;
    }