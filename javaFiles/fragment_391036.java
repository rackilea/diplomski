ArrayList<Dog> dogs = new ArrayList<Dog>(); 

 while(sc.hasNextLine())
{

// read a line from the input file via sc into line
  line = sc.nextLine();
  StringTokenizer stk = new StringTokenizer(line);
  String name = stk.nextToken();
  String breed = stk.nextToken();
  int month = Integer.parseInt(stk.nextToken());
  int day = Integer.parseInt(stk.nextToken());
  int year = Integer.parseInt(stk.nextToken());
  double weight = Double.parseDouble(stk.nextToken());

  Dog list = new Dog(name, breed, month, day, year, weight);

  dogs.add(list);

}