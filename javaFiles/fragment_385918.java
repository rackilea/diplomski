List<Cyclist> cyclists = new ArrayList<>(); // Declared as field

public void riders() {
    for (cyclist : cyclists){
      System.out.print(cyclist.getName())
    }
}



public void abilities() {

//Pardilla blir til!
Cyclist c1 = new Cyclist();

c1.setName("Sergio Pardilla");
c1.setMountain(75);
c1.setTimeTrial(60);
c1.setSprint(60);
c1.setAge(30);

System.out.println(c1.getName() + "'s abilities:");
System.out.println("Mountain - " + c1.getMountain());
System.out.println("TimeTrial - " + c1.getTimeTrial());
System.out.println("Sprint - " + c1.getSprint());
System.out.println("Age - " +c1.getAge());

cyclists.add(c1); //Add cyclist to cyclists list
}