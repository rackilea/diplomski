JButton b = new JButton("Remove!");
b.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
            try {
                textPane.getDocument().remove(0, 1);
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        }
    });