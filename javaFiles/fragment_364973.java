DefaultListModel model = new DefaultListModel();
model.addElement("Fender");
model.addElement("Gibson");
model.addElement("Ibanez");
model.addElement("Paul Reed Smith");
model.addElement("Jackson");
model.addElement("Godin"); // The model has 6 elements

JList list = new JList(model);
list.setVisibleRowCount(5); // I want to show only 5 elements, then scroll the list

list.addComponentListener(new ComponentAdapter() { // ComponentAdapter implements ComponentListener interface
    @Override
    public void componentResized(ComponentEvent e) {
        JList list = (JList)e.getComponent();
        int divider = Math.min(list.getVisibleRowCount(), list.getModel().getSize());
        list.setFixedCellHeight(list.getVisibleRect().height / divider);
    }
});

JPanel content = new JPanel(new BorderLayout());
content.add(new JScrollPane(list));