class Coins {
    public double[] coins = { 50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01 };
    public String[] coinsName = { "Fifty Pounds", "Twenty Pounds", "Ten Pounds", "Five Pounds", "Two Pounds",
            "One Pound", "Fifty Pence", "Twenty Pence", "Ten Pence", "Five Pence", "Two Pence", "One Pence" };
}

public class Coinscalculate {
    public static void main(String[] args) {
        calc(11.25, 20);
    }

    public static void calc(double purchasePrice, double cash) {
        Coins obj = new Coins();
        int res = 0;
        StringBuilder sb = new StringBuilder();
        if (purchasePrice == cash) {
            System.out.println(res);
        } else if (cash > purchasePrice) {
            cash -= purchasePrice;
            for (int i = 0; i < obj.coins.length; i++) {
                if (cash >= obj.coins[i]) {
                    cash -= obj.coins[i];
                    cash = Math.round(cash * 100.0) / 100.0;
                    sb.append(obj.coinsName[i] + ", ");
                }
            }
        }
        String changeAmt = sb.toString();
        changeAmt = changeAmt.substring(0, changeAmt.lastIndexOf(",")); // Remove the last ','
        System.out.println(changeAmt);
    }
}