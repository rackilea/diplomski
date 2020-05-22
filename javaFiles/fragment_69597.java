public void transferTo(Account bank, double x) {
    if (x <= this.balance) {
        withdraw(x);
        bank.deposit(x);
        System.out.println("\nTransfer succesful. Tansfered: $" + x);
    } else { //does not need to be else if, because if not <=, it MUST be >.
        System.out.println("\nTransfer failed, not enough balance!");
    }
}