tray_icon.addMouseListener(new MouseListener() {
     @Override
     public void mouseClicked( MouseEvent e ) {
       Gui.this.setVisible(true);
       Gui.this.setState (Frame.NORMAL);
     }
   }