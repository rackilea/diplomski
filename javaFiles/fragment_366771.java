int position = 0;
System.out.print("move: ");
String car = Global.keyboard.nextLine();
if (car.equals("r"))
    position += 1;
if (car.equals("R"))
    position += 1;
if (car.equals("l"))
    position -= 1;
if (car.equals("L"))
    position -= 1;
    System.out.print(position);