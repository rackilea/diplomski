FaceCaptions.drawPhase1(tim);

FaceCaptions.drawPhase2(tim);


public static void drawPhase1(Turtle tim){
    TurtleAlphabet.drawABoldSize(tim, Color.blue, true, 1);
    TurtleAlphabet.drawWBoldSize(tim, Color.white, true, 1);
    TurtleAlphabet.drawKBoldSize(tim, Color.red, true, 1);
    TurtleAlphabet.drawWBoldSize(tim, Color.blue, true, 1);
    TurtleAlphabet.drawABoldSize(tim, Color.white, true, 1);
    TurtleAlphabet.drawRBoldSize(tim, Color.red, true, 1);
    TurtleAlphabet.drawDBoldSize(tim, Color.blue, true, 1);
}

public static void drawPhase2(Turtle tim){
    TurtleAlphabet.drawABoldSize(tim, Color.yellow, true, 1);
    TurtleAlphabet.drawWBoldSize(tim, Color.orange, true, 1);
    TurtleAlphabet.drawABoldSize(tim, Color.yellow, true, 1);
    TurtleAlphabet.drawRBoldSize(tim, Color.orange, true, 1);
    TurtleAlphabet.drawDBoldSize(tim, Color.yellow, true, 1);
}