public class BankTableModel extends AbstractTableModel {
  private List<Operation> operations;

  public BankTableModel(Bank bank) {
    operations = bank.getOperations();
    bank.addOperationEventListener(...);
  }

  public Object getValueAt(int row, int column) {
    return operations.get(row)...
  }
}