listOfButtons[i].addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        questList[temp].incrementNumerator(1);
        ((JButton) e.getSource()).setText(questList[temp].getValue());
    }
});