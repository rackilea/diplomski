String input = "nothing";

while(!input.matches("[0-9]+"))
{
    System.out.print("Please Enter your Student ID (Numbers Only):  ");
    Scanner in = new Scanner(System.in);
    input = in.nextLine();
}

// now we have input of string numbers
doRestOfProgram();