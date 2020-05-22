public void deposit() {
    String d = etDepositAmount.getText().toString();
    Integer depositAmount = 0;
    try
    {
       depositAmount = Integer.valueOf(d);
    }
    catch(NumberFormatException ex)
    {
       // Uh oh! Bad input!
    }

    if (depositAmount > playerCash || depositAmount <= 0) 
    {
        new AlertDialog.Builder(this).setTitle("Wait")
                .setMessage("Please enter a valid deposit value.")
                .setPositiveButton("OK", null).show();
        etDepositAmount.setText("");
    } else {
        int newBankBalance = playerBalance + depositAmount;
        playerBalance = newBankBalance;
        playerCash = (playerCash - depositAmount);

        bankBalance.setText("Bank Balance: $" + playerBalance);
        cash.setText("Cash in hand: $" + playerCash);
        etDepositAmount.setText("");

        Player stats = new Player(this);
        stats.open();
        stats.bankDeposit(playerId, playerCash, playerBalance);
        stats.close();
    }
}