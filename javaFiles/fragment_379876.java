public static double getBillTotal(double tipPercentage, double subtotal, int satisfactionNumber) {

    double totalWithTip = (subtotal + (getPercentage(satisfactionNumber) * subtotal));
    return totalWithTip;

}