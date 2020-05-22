String s = null;
while(!validInput) 
{
try 
{
if(s != null){
    indexPosition = Integer.parseInt(s);
}
else{
indexPosition = input.nextInt();
}
System.out.println(randomInteger[indexPosition]);
validInput = true;
} catch ( InputMismatchException | NumberFormatException | IndexOutOfBoundsException ex ) {

System.out.println("Please enter a valid integer between 0 and 100 or type quit to exit: ");
input.nextLine();
s = input.next();
if(s.equals("quit")){
System.exit(0);
 } 
}
}