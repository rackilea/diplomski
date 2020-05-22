public static void main(String[] args) {
    ....
    System.out.println("The bill total is: " + getBillTotal(subtotal, satisfactionNumber));
}

...

public static double getBillTotal(double subtotal, int satisfactionNumber) {

    double totalWithTip = (subtotal + (getPercentage(satisfactionNumber) * subtotal));
    return totalWithTip;

}