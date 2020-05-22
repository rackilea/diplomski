boolean inputFlag;
do {
System.out.println("Please select the type of shape you wish to calcuate information for: "
    + newLine + "A: Square" + newLine + "B: Rectangle" + newLine + "C: Circle");

  char typeShape = input.next().charAt(0);
  String shape = Character.toString(typeShape);

  switch (shape.toLowerCase()) {
    case "a":
      inputFlag = false;
      //do something
      break;
    case "b":
      inputFlag = false;
      //do something
      break;
    case "c":
      inputFlag = false;
      //do something
      break;
    default:
      System.out.println("Invalid selection. Please re-enter shape.");
      inputFlag = true;
  }
} while (inputFlag);