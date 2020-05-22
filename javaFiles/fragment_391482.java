class Action1 implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            deleteFile();
            JLabel label = new JLabel("Deletion was successful");
            JPanel panel = new JPanel();
            panel.add(label);
        }
    }