public void valueChanged(ListSelectionEvent e)
{
    JList list = (JList)e.getSource();
    int selected = list.getSelectedIndex();
    int previous = selected == e.getFirstIndex() ? e.getLastIndex() : e.getFirstIndex();

    System.out.println();
    System.out.println("Selected:" + selected);
    System.out.println("Previous:" + previous);
}