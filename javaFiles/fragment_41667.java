Arrays.sort(BankAccounts, 0, BankAccount.getNumberOfAccounts(), new Comparator<BankAccount>() {
        @Override
        public int compare(BankAccount o1, BankAccount o2) {
            if (o1.getBalance() > o2.getBalance()) return -1;
            if (o1.getBalance() < o2.getBalance()) return 1;
            return 0;
        }
    }
);