Scanner scan = new Scanner(System.in);

System.out.print("Enter some words here: "); // Captures word(s)
String inputEntry = scan.nextLine(); 

System.out.print("Enter a character here: "); // Captures char
String inputCharacter = scan.nextLine();

// validate

// then

int len = inputEntry.length();
inputEntry = inputEntry.replace(inputCharacter, "");
int newlen = inputEntry.length();
System.out.format("There is %d occurrence(s) of %s in the test.%n", 
                                            len - newlen, inputCharacter);