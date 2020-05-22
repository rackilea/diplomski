final int temp = correctScore;
    submit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            score.setText("Score: " + temp + "/10");
        }
    });
}  // <- CLOSE THE FOR LOOP HERE

panel.add(submit);