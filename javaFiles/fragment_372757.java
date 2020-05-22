left.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            revalidate();
        }

    });