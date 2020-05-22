userInput.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        chatWindow = new JScrollPane(new JTextArea(processMessage()));

    }
});