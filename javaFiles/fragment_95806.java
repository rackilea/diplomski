send.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        Sender sender = getSender();
        if (sender != null) {
            sender.sendMessage(...);
        }
    }
});