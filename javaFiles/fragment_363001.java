private static Square getSquareColor()
{
    String input = JOptionPane.showInputDialog("Enter a color");

    switch(input.toLowerCase()) {
        case "black":   return new Square(Color.BLACK);
        case "blue":    return new Square(Color.BLUE);
        ...
    }

    return = new Square(Color.PINK);

}