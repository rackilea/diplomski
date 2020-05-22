System.out.println("Gebäudename eingeben(egal): ");
String Name = user_input.nextLine();
Building Building = new Building(Name);
System.out.println("Stockname eingeben(eg): ");
Name = user_input.nextLine();
Building.newFloor(Name);
System.out.println("Raumname eingeben(wohnen): ");
Name = user_input.nextLine();
Building.floor.get(0).newRoom(Name);