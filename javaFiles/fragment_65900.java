// ..
    panel.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                panel.add(new JLabel(img));
                System.out.println("Mouse Click detected");
            }}
            );