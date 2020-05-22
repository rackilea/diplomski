for(StudentLoan loan : loans) {
        int index=0;

        // print loans with amount > 0

        if (loan.loanAmount > 0) {
            System.out.print(index + " : ");
            loan.printDetails();
            index++;
        }

        // delete loans with amount = 0

        if (loan.loanAmount == 0) {
           loans.remove(loan) // UNSAFE! see edit below
        }
    }