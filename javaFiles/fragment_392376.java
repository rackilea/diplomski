String input = "";

do {
  input = keyboard.nextLine();

  if (input.equals("distance")) {
    ex3.getDistance();
  } else if (input.equals("fuel")) {
      ex3.getFuelUsed();
  } else if (input.equals("refuel")) {
      ex3.Refuel();
  }
} while (!input.equals("done"));

System.exit(0);