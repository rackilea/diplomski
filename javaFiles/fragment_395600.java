JButton b = new JButton("Answer!");
b.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
        new AnswerWorker().execute();
    }
});