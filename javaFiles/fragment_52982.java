public class BankApplication extends Application implements
    EventHandler<ActionEvent> {
private static Customer customer;
private static SavingsAccount bankAccount;

private Button executeButton = new Button("Execute");
private Label customerIDLabel;
private Label balanceLabel;
private TextField depositTextField;
private TextField withdrawTextField;
private Label customerNameLabel;

public static void main(String[] args) {
    customer = new Customer("Amanda", 1009);
    bankAccount = new SavingsAccount("Amanda", 150);

    Application.launch(args);

}

public BankApplication() {
    customerNameLabel = new Label("Customer name: " + customer.getName());
    customerIDLabel = new Label("Customer ID: " + customer.getID());

    balanceLabel = new Label("Current balance: $" +
            bankAccount.getBalance() + ".");
    depositTextField = new TextField("Amt to deposit");
    withdrawTextField = new TextField("Amt to withdraw");
}


@Override
public void start(Stage primaryStage) throws Exception {

    FlowPane root = new FlowPane();
    Scene scene = new Scene(root, 400, 300);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Bank application");

    executeButton.setOnAction(this);

    HBox middle = new HBox(depositTextField, withdrawTextField);
    middle.setSpacing(8);
    middle.setPadding(new Insets(8));

    VBox top = new VBox(customerNameLabel, customerIDLabel);
    VBox bottom = new VBox(executeButton, balanceLabel);
    top.setSpacing(8);
    bottom.setSpacing(8);
    top.setPadding(new Insets(8));
    bottom.setPadding(new Insets(8));

    root.getChildren().add(top);
    root.getChildren().add(middle);
    root.getChildren().add(bottom);


    primaryStage.show();


}

@Override
public void handle(ActionEvent event) {
    if (event.getSource() == executeButton) {

        String depositAmount = depositTextField.getText();
        String withdrawAmount = withdrawTextField.getText();

        if (isDouble(depositAmount) == true) {

            double old_balance = bankAccount.getBalance();

            bankAccount.deposit(Double.parseDouble(depositAmount));

            double new_balance = bankAccount.getBalance();

            if (new_balance != old_balance) {
                updateBalanceLabel();
                depositTextField.clear();
                depositTextField.setText("Amt to deposit");
            } else if (new_balance == old_balance) {
                depositTextField.clear();
                depositTextField.setText("Amt to deposit");
            }
        }
    }
}//...