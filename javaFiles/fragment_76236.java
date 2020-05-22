System.out.println("Okay, " + name + ", you are a " + gender + ". Now, tell me, what is your age?");
//Here you enter --> 18 This is a prove
int age = input.nextInt();
input.nextLine();
//Now the Scanner go to a new line (because of the nextLine) but without storing the value
System.out.println("Great! We're almost done. What are three interests you have?");
//Now you are in a new line and you are going to be able to write. For example --> I am reading this.
String interests = input.nextLine();