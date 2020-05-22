public class ColorButton extends JButton implements ActionListener{
    Color actualColour;  // never assigned a value on object creation
    Color grey = new Color(128, 128, 128);
    Color black = new Color(0, 0, 0);

    //...

    Color stateBack = grey;
    Color stateFront = actualColour;  // actualColour is null here
    Color stateFinished = black;

    // ....