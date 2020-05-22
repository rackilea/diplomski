public void buildUI() {
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JButton button = new JButton("Button");
panel.add(button);
button.addActionListener( new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        System.out.println("The current panel is " + ((JButton)e.getComponent()).getParent());
    }

});
frame.add(panel);
frame.pack();
frame.setDefaultCloseBehavior(JFrame.CLOSE_ON_EXIT);
frame.setVisible(true);
}