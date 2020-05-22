Scanner scanner = new Scanner(new File(INPUT_ACCOUNT_FILE));
Collection<Account> bank = new ArrayList<>();

while (scanner.hasNext()) {
   String[] fields = scanner.next().split(",");
   if (fields.length < MAX_VALUES_PER_LINE) {
      continue; // incomplete row, skip it or maybe throw some exception?
   }

   String number = fields[ACCOUNT_NUMBER_COUNT];
   Customer customer = new Customer(fields[FIRST_NAME_COUNT], fields[LAST_NAME_COUNT]);
   double balance = Double.valueOf(fields[BALANCE_COUNT]);
   String type = fields[LAST_VARIABLE_COUNT];

   Account a = null;
   switch (type) {
      case "N": {
         a = new CheckingAccount(number, customer, balance);
         break;
      }
      case "0.02": {
         a = new SavingsAccount(number, customer, balance);
         break;
      }
      default: {
         continue; // unknown type of account, skip it or maybe throw some exception?
      }
   }
   bank.add(a);
}