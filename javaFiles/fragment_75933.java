String textLine = null;
System.out.println("Enter a line of text to add to the array: ");
while (!(textLine = userInput.readLine()).isEmpty())
    myArr.add(textLine);
    System.out.println("Enter a line of text to add to the array: ");
} ;