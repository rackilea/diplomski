System.out.println("Please choose item #"+ i+": ");
while (!scan.hasNextInt()) //this while loop checks that an integer value has been entered
{
    System.out.println("Please enter an integer value from the above menu.");
    scan.next(); // skip bad token
}
item = scan.nextInt();