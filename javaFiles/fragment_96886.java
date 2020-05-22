private class Play implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        JButton src = (JButton) event.getSource();

        //create board
        String[][] board = {{"1", "2", "3"},
                            {"4", "5", "6"},
                            {"7", "8", "9"}
                            };
        //...