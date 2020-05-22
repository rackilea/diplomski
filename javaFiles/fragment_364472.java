if (monthlyPayment < loanAmount * interestRate) {
        System.out.println("your warning...");
}
for (months = 1; months <= loanAmount; months++) {
    interest = (loanAmount * interestRate);
    principal = monthlyPayment - interest;
    loanAmount = loanAmount - principal;
}
System.out.println("Number of months: " + months);