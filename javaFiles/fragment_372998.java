Scanner keyboard = new Scanner(System.in);
  List<Class1> all = new ArrayList<Class1>();
  int quantity = 0;
  while(quantity <2) // whatever the max number of entries should be
  {

        System.out.println("text: ");
        String x = keyboard.nextLine();

        System.out.println("text2:  ");
        String y = keyboard.nextLine();

        System.out.println("text 3: ");
        String z = keyboard.nextLine();

        Class1 p = new Class1(x, y, z);
        all.add(p);
        quantity++;
    }
        for (int i = 0; i < all.size(); i++)
             System.out.println(all.get(i).getFirstName()+(" ")+
             all.get(i).getSurname()+" from " +all.get(i).getTeamName()+" with number 
             " +(i) +" added");