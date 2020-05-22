button9.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton btn = (JButton)source;
            // Go ahead and do what you like
        }
    }
});