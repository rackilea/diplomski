// find the index of the last operation that brings balance below 0
int balance = 0;
int firstIndexWhereClosed = 0;
for (; balance >= 0 && firstIndexWhereClosed < parenthesisBalancePerElement.size(); firstIndexWhereClosed++) {
    int elementBalance = parenthesisBalancePerElement.get(firstIndexWhereClosed);
    balance += elementBalance;
}
// use firstIndexWhereClosed