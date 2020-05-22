proc.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Object selectedItem = proc.getSelectedItem();
            if ("Choice1".equals(selectedItem)) {
                setGyd(Option1);
            }
            if ("Choice2".equals(selectedItem)) {
                setGyd(Option2);
            }
        }
    });
    G.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent a) {
            Object selectedItem = G.getSelectedItem();
            if ("A1".equals(selectedItem)) {
                setLaikas(Option3);
            }
            if ("A2".equals(selectedItem)) {
                setLaikas(Option4);
            }
            if ("A3".equals(selectedItem)) {
                setLaikas(Option5);
            }
        }
    });//JComboBox