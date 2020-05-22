// declare string here so it's accessible in the while loop condition
String textLine = null;
do
{
    System.out.println("Enter a line of text to add to the array: ");
    textLine = userInput.readLine();
    myArr.add(textLine);
}
while (!textLine.isEmpty());
myArr.remove(myArr.size()-1);