if (!inputIsValid( inputVal, 500, main) {
  if (inputVal < 500) {
    amount_to_pay.setError("Min Charge: 500");
    pay_of_loan.setEnabled(false);
  }
  else if (inputVal > main) {
    amount_to_pay.setError("Max Charge: " + ccNum);
    pay_of_loan.setEnabled(false);
  }
  else
  {
    amount_to_pay.setError("For partial pays, min remaining: " + 500);
    pay_of_loan.setEnabled(false);
  }
} else {
  amount_to_pay.setError(null);
  pay_of_loan.setEnabled(true);
}