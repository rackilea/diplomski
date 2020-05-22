JButton homeScore2 = new JButton("+2");
    homeScore2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            ScoreListener listener = new ScoreWindow();
            listener.homeScore(2);
        }
    });