final JButton btnAccept = new JButton("Accept");
btnAceptar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        dataset.setValue(0);
        Timer timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int current = dataset.getValue();
                if (current < 40) {
                    current++;
                    dataset.setValue(current);
                } else {
                    ((Timer)evt.getSource()).stop();
                }
            }
        });
        timer.start();
    }
});
panel.add(btnAceptar);