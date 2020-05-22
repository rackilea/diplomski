double grossPay;
double yearlyCompensation;
if (cmbPayPeriod.getSelectedItem().equals("52 Week Pay Period")) {
    grossPay = basicPay + overtimePay;
    yearlyCompensation = grossPay * 52;
} else if (cmbPayPeriod.getSelectedItem().equals("n")) {
    grossPay = (basicPay + overtimePay) * 2;
    yearlyCompensation = grossPay * 26;
} else {
    //this must be an error
    //just bail out:
    return;
}