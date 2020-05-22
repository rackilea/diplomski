sbar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            if (lbl.isVisible()) {
                lbl.setVisible(false);
            } else {
                lbl.setVisible(true);
            }
        }
    });