Scanner keyb = new Scanner(System.in);
keyb.useDelimiter("\n"); // You can try System.lineSeparator() but it didn't work in IDEA
int age;

System.out.println("How old are you?");
while(!keyb.hasNextInt())
{
    keyb.next();
    System.out.println("No really. How old are you?");
}

age = keyb.nextInt();
System.out.println("You are " + age + " years old");