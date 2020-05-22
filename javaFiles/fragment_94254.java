ArrayList<Catagory> list=new ArrayList<>();
list.add(new Catagory(1, "Name 1", "Description 1", "Type 1")); // Its index is 0.
list.add(new Catagory(2, "Name 2", "Description 2", "Type 2")); // Its index is 1.
list.add(new Catagory(3, "Name 3", "Description 3", "Type 3")); // Its index is 2.
list.add(new Catagory(4, "Name 4", "Description 4", "Type 4")); // Its index is 3.

//Keep on adding these as many as you want, and another way:
Catagory person = new Catagory(5, "Lisa", "Female", "Good");
list.add(person); // Its index will be 4.

//To access these variables just use index:
String firstName=list.get(0).getName(); // Will return Name1.
String secondDescription=list.get(1).getDesc); // Will return Description 2.

//To change the some values, just use this:
list.get(0).setName("Alex");
list.get(0).setDesc("Male");
list.get(0).setId(9);