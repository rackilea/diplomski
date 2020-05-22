public LogPane() {
    super();
    JPopupMenu pop = new JPopupMenu();
    final LogPane l = this;
    final JMenuItem copy = new JMenuItem("Copy      CTRL+C");
    copy.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            selected = l.getSelectedText();
            if(selected==null)
                return;
            StringSelection clipString = new StringSelection(selected);
            clipbd.setContents(clipString,clipString);
        }

    }); 
    pop.add(copy);
    pop.addPopupMenuListener(new PopupMenuListener() {
        public void popupMenuCanceled(PopupMenuEvent e) {}
        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            copy.setEnabled(l.getSelectedText() != null);
        }
    });
}