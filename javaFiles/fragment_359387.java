long sum = 0;
for (MoneyManager mm : listOfMoneyManager) { // or whatever your local variable is
    sum += mm.getIncome() - mm.getExpense();
}

// after the iteration you have the total

System.out.println (sum);