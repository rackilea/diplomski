if (hoursWorked > 40) {
    overtimeHours = (hoursWorked - 40);
    overtimePay = (rateOfPay * 1.5 * overtimeHours); // Conditional assignment, as its not assigned by default nor in the else

    regularPay = (40 * rateOfPay); // Conditional assignment, as its not assigned by default nor in the else

    grossPay = (regularPay + overtimePay); // This won't be a problem as its assigned some value in else part too.
}else {
    grossPay = (rateOfPay*hoursWorked);
}