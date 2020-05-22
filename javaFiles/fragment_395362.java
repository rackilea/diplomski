private class AccountUpdater implements ActionListener {
    private Account account;

    public void setAccount(Account account) {
        this.account = account;
        tf_updateDOB.setText(account.getAccountDOB());
        tf_updatePlan.setText(account.getAccountPlan());
        tf_updateCard.setText(account.getAccountCard());
        tf_updateName.setText(account.getAccountName());
    }

    @Override
    public void actionPerformed(ActionEvent f) {
        account.setAccountDOB(tf_updateDOB.getText());
        account.setAccountCard(tf_updateCard.getText());
        account.setAccountPlan(tf_updatePlan.getText());
        account.setAccountName(tf_updateName.getText());
        menuScreen.setVisible(true);                                                                                                   
        updateScreen.setVisible(false);                        
    }
}

AccountUpdater updater = new AccountUpdater();
updateSubmitBtn.addActionListener(updater);