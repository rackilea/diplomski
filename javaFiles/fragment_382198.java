boolean found = false;
while(in.hasNext())
{
    String line=in.nextLine();
    if(line.contains(userInput.toUpperCase())) {
        System.out.println(line);
        found = true;
    }
}
if (found == false) {
    System.out.println("No Planet with the HR code: " + userInput.toUpperCase() + " Was found.");
}