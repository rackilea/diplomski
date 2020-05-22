@Override
public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

  SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        System.out.println(i1.isSelected());
        System.out.println(i2.isSelected());
        System.out.println(i3.isSelected());
     }
  });
}