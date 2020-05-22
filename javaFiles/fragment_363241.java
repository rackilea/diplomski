btnGuess.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        try {
            double num = Double.parseDouble(textField.getText());
            // EPSILON is a constant in the class, declared as 
            // public static final double EPSILON = 0.00001;
            if (Math.abs(num - answer) < EPSILON) {
                lblResult.setText("CORRECT!");
            } else {
                lblResult.setText("WAITING");
                final String comment = num > answer ? "TOO LARGE" : "TOO SMALL";
                int delay = 1000;
                Timer timer = new Timer(delay, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        lblResult.setText(comment);
                    };
                });
                timer.setRepeats(false);
                timer.start();
            }
        } catch (Exception e1) {
            lblResult.setText("Error");
        }
    }
});