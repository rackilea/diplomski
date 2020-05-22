private void giveCash(int money) {
    int banknotes[] = {10, 20, 50, 100, 200, 500};
    StringBuffer cash = new StringBuffer();
    int i = banknotes.length - 1;
    while (i >= 0) {
        if (banknotes[i] > money) {
            i--;
        } else {
            int amount = (int) Math.floor(money/banknotes[i]);
            cash.append(banknotes[i]).append("x").append(amount).append(" ");
            money -= banknotes[i]*amount;
        }
    }
    TextView tvCash = (TextView) findViewById(R.id.cash);
    tvCash.setText(cash);
}