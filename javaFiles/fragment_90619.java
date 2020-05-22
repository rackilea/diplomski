public void monthlyFee(double f) {
        //will take a double value as a param and apply that value to every BankAccount object
        for (int i = 0; i < bAcct.length; i++){
            if(bAcct[i] !=null) {
                bAcct[i].adjust(f);
            }
        }
    }