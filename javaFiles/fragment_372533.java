ButtonDemo(){
    JFrame jfrm = new JFrame("A Button Example");

    // ...

    // the variable below is being re-declared in the constructor and is thus
    // local to the constructor. It doesn't exist outside this block.
    JLabel jlab = new JLabel("Press a button.");

    // ...
}