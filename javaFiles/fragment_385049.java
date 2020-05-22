import java.util.ArrayList;

public class Balance {
    ArrayList<Balance> subAccounts = new ArrayList<Balance>();
    String accountID = null;
    Double amount = null;

    public double getSum() {
        if (subAccounts != null) {
            Double sum = 0.0;
            for (int i = 0; i < subAccounts.size(); i++) {
                sum += subAccounts.get(i).getSum();
            }
            return amount + sum;
        } else {
            return amount;
        }       
    }

    public static void main(String[] args) {
        Balance bs1 = new Balance();
        Balance bs2 = new Balance();
        Balance bs3 = new Balance();
        bs1.amount = 100.0;
        bs2.amount = 150.0;
        bs3.amount = 300.0;
        ArrayList<Balance> subAccounts1 = new ArrayList<Balance>();
        bs2.subAccounts = null;
        bs3.subAccounts = null;
        subAccounts1.add(bs2);
        subAccounts1.add(bs3);
        bs1.subAccounts = subAccounts1;
        double sum = bs1.getSum();
        System.out.println(sum);
    }
}