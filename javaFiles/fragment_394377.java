public JButton createBtnLeft() {
    JButton btnLeft = new JButton("left");
    btnLeft.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //TODO
            lblPicture2.setIcon(null);
            lblPicture2.setBackground(Color.BLACK);
            lblPicture1.setIcon(new ImageIcon(ExampleGUI.class.getResource("/gui/schlange.gif")));

        }
    });
    btnLeft.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
    return btnLeft;
}