protected Customer customer;
protected SavingsAccount bankAccount;
private Button executeButton = new Button("Execute");
private Label customerIDLabel;
private Label balanceLabel;
private TextField depositTextField;
private TextField withdrawTextField;
private Label customerNameLabel;

public BankApplication(Customer customer, SavingsAccount bankAccount) {
    this.customer = customer;
    this.bankAccount = bankAccount;
    customerNameLabel = new Label("Customer name: " + customer.getName());
    customerIDLabel = new Label("Customer ID: " + customer.getID());

    balanceLabel = new Label("Current balance: $" +
            bankAccount.getBalance() + ".");
    depositTextField = new TextField("Amt to deposit");
    withdrawTextField = new TextField("Amt to withdraw");
}