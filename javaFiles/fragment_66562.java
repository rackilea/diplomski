System.out.println("Please state your name:");
person1.name = input.nextLine();

System.out.println("Please state your age:");
person1.age = input.nextInt();
input.nextLine();    // Advance to the next line

System.out.println("Do you have a pet?");
String answer = input.nextLine();