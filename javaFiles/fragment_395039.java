for(StudentLoan loan : loans) {
        int index=0;
        if (loans.loanAmount > 0) {
            System.out.print(index + " : ");
            loan.printDetails();
            index++;
        }
    }