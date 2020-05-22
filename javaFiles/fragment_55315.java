class SavingAccount(owner: String,
        balance: Double,
        val increasedBy: Double = 0.05
): BankAccount(owner, balance) {

}