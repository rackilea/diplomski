public class ProgrammingProject5 {
    public static void main(String[] args) {
        double startingDebt = 1000;
        double interestPerMonth = 0.015;
        double moneyDuePerMonth = 50;
        double debt = startingDebt;
        int m = 0;

        while (debt > 0) {
            double monthlyInterest = (debt*interestPerMonth);
            double monthlyOwed = moneyDuePerMonth - monthlyInterest;

            debt = debt - monthlyOwed;

            m++;
        }

        System.out.println("The amount of months until debt is 0:  " + m);
    }
}