public static double maxPayment(List<Employee> list) {
    double maxPay = 0;
    for (Employee e : list)
        maxPay = Math.max(maxPay, e.getPayment());
    return maxPay;
}