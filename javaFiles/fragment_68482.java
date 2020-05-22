public static String getDollarAmount(double pen, double nic, double dim, double qua) {
    double total;
    String amount;

    pen = pen * 0.01;
    nic = nic * 0.05;
    dim = dim * 0.10;
    qua = qua * 0.25;

    total = pen + nic + dim + qua;
    amount = ("$" + total);

    return amount;
}