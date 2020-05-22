// ..
    final JLabel label = new JLabel();
    panel.add(label);
    panel.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                label.setIcon(img);
                System.out.println("Mouse Click detected");
            }}
            );