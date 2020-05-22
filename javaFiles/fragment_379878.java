public static void main(String[] args) {
    ....
    double tipPercentage = getPercentage(satisfactionNumber);
    System.out.println("The bill total is: " + getBillTotal(tipPercentage, subtotal));
}

...

public static double getBillTotal(double tipPercentage, double subtotal) {

    double totalWithTip = (subtotal + (tipPercentage * subtotal));
    return totalWithTip;

}