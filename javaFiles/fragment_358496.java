Path relative = Paths.get("zoo.txt");
Path base1 = Paths.get("..", "..", "temp", "delete", "dictionary.txt");
Path base2 = Paths.get("a",  "b",  "c",    "d",      "e");

Path relativized1 = base1.relativize(relative);
System.out.println("relativized1: "+relativized1);
Path relativized2 = base2.relativize(relative);
System.out.println("relativized2: "+relativized2);

Path resolved1 = base1.resolve(relativized1).normalize();
System.out.println("resolved1="+resolved1);
Path resolved2 = base2.resolve(relativized2).normalize();
System.out.println("resolved2="+resolved2);