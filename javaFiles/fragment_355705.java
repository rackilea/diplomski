final JTextArea textDisplay = new JTextArea(10,48);
 ...
listButton.addActionListener(new ActionListener() 
    {
        public void actionPerformed(ActionEvent event) 
        {
        ...
        textDisplay.append("Student " + i);