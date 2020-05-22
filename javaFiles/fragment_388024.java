boolean isValid = true;
//code checking for date validity goes here, set isValid to false when validity check fails
if (d1<1||d1>31||m1<1||m1>12) {
    JOptionPane.showMessageDialog(null,"Invalid Date 1");
    isValid = false;
}
...

if (isValid) {
    if(y1>y2)
        JOptionPane.showMessageDialog(null,"Date1 > Date2");
    ...
}