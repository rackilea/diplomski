JFrame frame = new JFrame();

    JButton button = new JButton("Click Here");
    frame.add(button);

    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Clicked");
        }
});