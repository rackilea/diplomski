hapus.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String text = output.getText();
        output.setText(text.substring(0,text.length()-1));
    }
});