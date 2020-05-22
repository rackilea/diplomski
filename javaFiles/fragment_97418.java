Menu menu = new Menu();
menu.getMntmTestMenuItem().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            internalFrames.desktopPane.add(internalFrames.test);
            internalFrames.test.setVisible(true);
    }
});