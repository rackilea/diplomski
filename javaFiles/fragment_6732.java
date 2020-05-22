JButton button1 = new JButton("Some Text");
 JButton button2 = new JButton("Some Other Text");

  button1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "I was clicked !");
        } });

   button2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Second button was clicked!");
        } });