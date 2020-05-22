button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        //should print out the location of the button that was clicked
        System.out.println( ((JButton)e.getSource()).getLocation() );
    }
});