box.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {

            int selection = box.getSelectedIndex();
            switch (selection) {
                case 0:
                    JOptionPane.showMessageDialog(null, "you have selected option 1");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "you have selected option 2");
                    break;
                default:
                    break;
            }
        }
    });