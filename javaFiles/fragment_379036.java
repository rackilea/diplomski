public DrawingPanel() {
    setPreferredSize(new Dimension(300, 300));
    setPreferredSize(new Dimension(300, 300));
    setLayout(null);

    init(); //sets properties
    a.setFont(font1);
    a.setVisible(true);
    a.setBounds(105,200,300,100);
    add(a);

    retry.setBounds(175,260,46,46);
    retry.addMouseListener(new MouseListener() {
        public void mouseClicked(MouseEvent event) {
            init(); //reset properties
        }

        //...
    });
    add(retry);            
}