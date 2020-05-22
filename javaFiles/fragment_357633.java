button.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            layout.show(container, "panel2");
            container.setPreferredSize(new Dimension(100, 100));
            frame.pack();
        }
    });