//holds current resistor's value
Double val;

while(true) {
    System.out.println("Enter Resistor #" + ++n);
    val = keyboard.nextDouble();

    //only add if higher than 0
    if (val > 0.0) {
        myRes.resistor.add(val);
    }
    //0 entered, so finish the loop
    else break;
}