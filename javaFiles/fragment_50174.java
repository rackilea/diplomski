btn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            btn.setEnabled(false);
            doSomething() ;
            btn.setEnabled(true);
        }
    });