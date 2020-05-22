play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //need to remove this panel here
            frame.getContentPane().remove(Launcher.this);
            frame.ThreeD();
        }
    });