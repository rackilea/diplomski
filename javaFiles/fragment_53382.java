public void actionPerformed(ActionEvent e) {
  PopupFactory factory = PopupFactory.getSharedInstance();
  final Popup popup = factory.getPopup(text1, new JLabel("POPUP"),frame.getX()+300,frame.getY()+300);
  text1.addHierarchyListener(new HierarchyListener() {

    public void hierarchyChanged(HierarchyEvent e) {
      if (e.getID() == HierarchyEvent.HIERARCHY_CHANGED
          && (e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0) {
        popup.hide();
      }
    }
  });
  popup.show();
}