private class Play implements ActionListener {

    private String[][] board = {{"1", "2", "3"},
                                {"4", "5", "6"},
                                {"7", "8", "9"}
                                };

    public void actionPerformed(ActionEvent event) {
        JButton src = (JButton) event.getSource();

        count++;
        if(count == 1 || count == 3 || count == 5 || count == 7 || count == 9 )
            letter = playerChoice;
        else if(count == 2 || count == 4 || count == 6 || count == 8 || count == 10)
            letter = computerChoice;
        //...