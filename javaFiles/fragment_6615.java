final Boolean click = false;    

    send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("outside variable 'click' is:" + click);
            }
        });