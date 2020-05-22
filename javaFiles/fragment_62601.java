/* This is to avoid a crazy 3-way switch. Generalised.
 * Instead of using a complicated if-else branch, we can use the number of true
 * and false to entail the intended action. */
/* This is the same as a ^ b ^ c (chained XOR), 
 * which is used to count the parity of truth values. */
int a = adjustment.adjustmentAccount.isIncrease ? 1 : 0;
int b = adjustment.increaseVATLine ? 1 : 0;
int c = adjustment.vatItem.isSalesType ? 1 : 0;

if ((a + b + c) % 2 == 1)
{
    entry2.setDebit(adjustment.total);          // Odd number of trues
    entry2.setCredit(0d);
}
else
{
    entry2.setCredit(adjustment.total);         // Even number of trues
    entry2.setDebit(0d);
}