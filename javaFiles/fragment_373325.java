private class FontColorAction implements ActionListener {
     private Color color;
     public FontColorAction (Color color){
          this.color = color;
     }

     public void actionPerformed(ActionEvent e){
          textarea.setForeground(color);
     }
}