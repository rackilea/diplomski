String textLine = null;
do
{
    System.out.println("Enter a line of text to add to the array: ");
    textLine = userInput.readLine();
    if (!textLine.isEmpty())
        break;
    myArr.add(textLine);
}
while (true);