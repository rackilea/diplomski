enum BankOperation {

    PLUS {
        public String getOutput(int delta) {
            return String.format("Adding %s dollars", delta);
        }
    },
    MINUS {

        @Override
        public String getOutput(int delta) {
            return String.format("Withdrawing %s dollars", delta);
        }
    };

    public abstract String getOutput(int delta);

    public static BankOperation getBankOperation(int oldAmount, int newAmount) {
        BankOperation operation = newAmount >= oldAmount ? BankOperation.PLUS : BankOperation.MINUS;
        int delta = Math.abs(newAmount - oldAmount);
        System.out.println(operation.getOutput(delta));
        return operation;
    }
}