System.out.println("Enter a line of text to add to the array: ");
String textLine = userInput.readLine();
while (!textLine.isEmpty())
    myArr.add(textLine);
    System.out.println("Enter a line of text to add to the array: ");
    textLine = userInput.readLine();
};