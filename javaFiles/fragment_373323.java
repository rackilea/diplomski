JButton nextButton = new JButton("Next");
nextButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog();
        dialog.setTitle("Title");
        dialog.setModal(true);
        dialog.getContentPane().add(...); // add components here
        dialog.pack();
        dialog.setVisible(true);
}