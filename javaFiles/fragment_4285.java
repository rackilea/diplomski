enum BankOperation { PLUS, MINUS; 

     public static BankOperation getBankOperation(int oldAmount, int newAmount) {
            BankOperation operation = newAmount >= oldAmount ? BankOperation.PLUS : BankOperation.MINUS;
            int delta = Math.abs(newAmount - oldAmount);
            switch (operation) {
                case PLUS:
                    System.out.println(String.format("Adding %s dollars", delta));
                    break;
                case MINUS:
                    System.out.println(String.format("Withdrawing %s dollars", delta));
                    break;
            }
            return operation;
        }
    };