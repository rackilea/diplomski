button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                height = height + 2;
                width = width + 2;
                repaint();
            }
        });