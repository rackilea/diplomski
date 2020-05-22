public void setGear(int newValue) {
    newValue = gear;
    //this wouldn't make much sense logic wise, but it is
    //valid code since I can use newValue only inside the setGear method

    speedUp(10);
    //the method 'speedUp' belongs to the bicycle class, so I can use
    //it inside another method belonging to the same class
}