import java.util.Iterator // add to imports

Iterator<StudentLoan> i = loans.iterator();

while (i.hasNext()) {
    StudentLoan loan = i.next();
    if (loan.getAmount() == 0) {
        i.remove();
    }
}