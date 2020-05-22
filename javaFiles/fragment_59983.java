for (final String playerName: players) {
    option = new JRadioButton(playerName, false);
    option.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent evt) {
            partner = playerName;
        }
    });
    partnerSelectionPanel.add(option);
    group.add(option);
}