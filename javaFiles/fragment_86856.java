@Override public boolean equals(Object other)
{
    if (other == null || other.getClass() != this.getClass())
    {
        return false;
    }
    BankTransaction otherTransaction = (BankTransaction) other;

    return accountNo == otherTransaction.accountNo 
        && transactionAmount == otherTransaction.transactionAmount
        && // etc;
}