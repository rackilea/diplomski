imgLbl.addMouseListener(new MouseAdapter() {
     @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getComponent() instanceof JLabel)
             lastFocused = (JLabel) e.getComponent();
     }
 });