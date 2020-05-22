Car car = new Car();
car.setModel("Torino");
session.save(car);

System.out.println(car.getId());               // prints 0
session.flush();
System.out.println(car.getId());               // prints something larger than 0