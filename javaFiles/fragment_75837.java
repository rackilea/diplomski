public static int loanLength(double loan, double interestAPR, double payment) {
    if (loan <= 0) {
        return 0;
    }
    double monthlyInterest = interestAPR / (12 * 100);
    double compounded = loan * (1 + monthlyInterest);
    return 1 + loanLength(compounded - payment, interestAPR, payment);
}

public static void main(String[] args) {
    System.out.println(loanLength(0, 0.90, 50)); // 0
    System.out.println(loanLength(1000, 10.0, 200)); // 6
    System.out.println(loanLength(1000, 0.1, 200)); // 6 (FWIW)
}