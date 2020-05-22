JButton b = new JButton(new AbstractAction() {

    {
       // Write initialization code here (as if it is inside a no-arg constructor)
       setLabel("This is a button")
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("button clicked");
    }
});