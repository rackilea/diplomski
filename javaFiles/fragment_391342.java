int number;

number = x;

int sum = 0;

//Message used for the sum, in the form of "1+2+3+4..."
String sumMessage = "";

while(number <= y){
    //Append the number and then "+" to sumMessage.
    sumMessage = sumMessage + number + "+";
    sum = sum + number;
    number++;
}
//Remove the final + in the sumMessage using substring.
sumMessage = sumMessage.substring(0, sumMessage.length() - 1);

// Here or in while it should write OptionPane.showMessageDialog(null, "1+2+3+4+5 "  + sum);


JOptionPane.showMessageDialog(null, sumMessage + " is: "  + sum);