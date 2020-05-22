GraphicsEnvironment graphEnviron = 
       GraphicsEnvironment.getLocalGraphicsEnvironment();
Font[] allFonts = graphEnviron.getAllFonts();

JComboBox<Font> fontBox = new JComboBox<>(allFonts);
fontBox.setRenderer(new DefaultListCellRenderer() {
   @Override
   public Component getListCellRendererComponent(JList<?> list,
         Object value, int index, boolean isSelected, boolean cellHasFocus) {
      if (value != null) {
         Font font = (Font) value;
         value = font.getName();
      }
      return super.getListCellRendererComponent(list, value, index,
            isSelected, cellHasFocus);
   }
});
JOptionPane.showMessageDialog(null, new JScrollPane(fontBox));