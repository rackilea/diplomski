ArrayList<Bills> myMonthlyTotals = mDBHelper.getDateByUserID(1);
Log.d("BILLSCOUNT","The number of bills extracted was " + String.valueOf(myMonthlyTotals.size()));
for (Bills b: myMonthlyTotals) {
    Log.d("MONTHYLTOTAL","Monthly total for " + b.getDateString() + " was " + String.valueOf(b.getAmount()));

}