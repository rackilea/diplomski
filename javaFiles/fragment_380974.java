class External {
    JFrame myFrame;
    ...

        class Internal implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                ...
                myFrame.setContentPane(createContentPane());
               //Or myFrame.setContentPane(External.this.createContentPane());
            }
        }
    ...
 }