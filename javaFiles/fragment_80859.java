public class IndexedAction extends AbstractAction {
    private int index;
    public IndexedAction(int index, String name) {
        this.index = index;
        putValue(NAME, name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Use the index some how...
    }
}

//...

JPopupMenu menu = new JPopupMenu();
menu.add(new IndexedAction(0, "Item 1"));
menu.add(new IndexedAction(1, "Item 2"));
menu.addSeparator();
menu.add(new IndexedAction(2, "Item 3"));
menu.add(new IndexedAction(3, "Item 4"));