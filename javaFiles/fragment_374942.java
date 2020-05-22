Scanner s = new Scanner(System.in);
  System.out.print("Enter name: ");
  String name = null;
  if(s.hasNext())
      name = s.next();
  System.out.println("Name is " + name);