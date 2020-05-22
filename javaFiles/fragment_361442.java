ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            textfield.get(button.indexOf(e.getSource())).setText("");
        }
    };

    for (int i = 0; i < 10; i++) {
        button.get(i).addActionListener(listener);
    }