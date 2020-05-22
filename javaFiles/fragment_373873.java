btnrefund.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
              JFrame frame = (JFrame) SwingUtilities.getRoot(component);
              frame.setContentPane(new RefundPanel());
            }
        });