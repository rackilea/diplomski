public class TransactionGroup {
    private List<SalesTransaction> transactions = new ArrayList<>();
    public void addTransaction(SalesTransaction st) {
        transactions.add(st);
    }
    public double getGrandTotal() {
        double sum = 0;
        for (SalesTransaction st : transactions) {
            sum += st.getCost();
        }
        return sum;
    }
}