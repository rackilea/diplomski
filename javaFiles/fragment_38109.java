boolean isstring = false;
  boolean isnumber = false;

  do {
   if (!scan.hasNextInt()) {
    isstring = true;
    name = scan.next();
   } else {
    isstring = false;
    System.out.println("Need String got Integer");
    scan.next();
   }
  } while (!isstring);

  do {
   if (scan.hasNextInt()) {
    isnumber = true;
    age = scan.nextInt();
   } else {
    isnumber = false;
    System.out.println("Need Integer got String");
    scan.next();
   }
  } while (!isnumber);

  do {
   if (!scan.hasNextInt()) {
    isstring = true;
    name2 = scan.next();
   } else {
    isstring = false;
    System.out.println("Need String got Integer");
    scan.next();
   }
  } while (!isstring);

  do {
   if (scan.hasNextInt()) {
    isnumber = true;
    age2 = scan.nextInt();
   } else {
    isnumber = false;
    System.out.println("Need Integer got String");
    scan.next();
   }
  } while (!isnumber);