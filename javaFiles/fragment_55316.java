class SavingAccount(owner: String = "Default Owner",
        balance: Double = 0.0,
        val increasedBy: Double = 0.05
): BankAccount(owner, balance) {

}