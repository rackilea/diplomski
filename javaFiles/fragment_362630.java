public GridFrame() {
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // Set the width,height,number of rows and columns
    final GridPanel panel = new GridPanel(300, 300, 10, 10);
    add(panel);
    JButton button = new JButton("Start");
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //Set the location of target grid
            panel.moveTo(5, 3);
        }
    });
    add(button, BorderLayout.SOUTH);
    pack();
}