ArrayList<Account> accounts = new ArrayList<>();
boolean isMatched = false;

while (true) {
    for (Account account : accounts) {
        System.out.printf("Customer name: ");
        String customerName = scanner.next();
        if (customerName.equals(account.getName())) {
            isMatched = true;
            break;
        }
    }
    if (isMatched) {
        System.out.println("You entered " + account.getName());
        break;
    }
    System.out.println("Please enter a valid name");
}