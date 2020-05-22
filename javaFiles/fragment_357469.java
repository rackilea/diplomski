// adjust the pref width in the component constraint
MigLayout layout = new MigLayout("wrap 2", "[][]");
final JComponent comp = new JPanel(layout);
for (int i = 0; i < 10; i++) {
    comp.add(new JLabel("some item: "));
    comp.add(new JTextField(i + 5));
}

MigLayout outer = new MigLayout("wrap 2", 
        "[][grow, fill]");
JComponent content = new JPanel(outer);
final JScrollPane pane = new JScrollPane(comp);
int prefBarWidth = pane.getVerticalScrollBar().getPreferredSize().width;
String pref = "(pref+" + prefBarWidth + "px)";
content.add(pane, "width " + pref);
content.add(new JTextField("some dummy") );
Action action = new AbstractAction("add row") {

    @Override
    public void actionPerformed(ActionEvent e) {
        int count = (comp.getComponentCount() +1)/ 2;
        comp.add(new JLabel("some Item: "));
        comp.add(new JTextField(count + 5));
        pane.getParent().revalidate();
    }
};
frame.add(new JButton(action), BorderLayout.SOUTH);
frame.add(content);
frame.pack();
frame.setSize(frame.getWidth()*2, frame.getHeight());
frame.setVisible(true);

// use a custom ScrollPaneLayout
MigLayout layout = new MigLayout("wrap 2", "[][]");
final JComponent comp = new JPanel(layout);
for (int i = 0; i < 10; i++) {
    comp.add(new JLabel("some item: "));
    comp.add(new JTextField(i + 5));
}

MigLayout outer = new MigLayout("wrap 2", 
        "[][grow, fill]");
JComponent content = new JPanel(outer);
final JScrollPane pane = new JScrollPane(comp);
pane.setLayout(new MyScrollPaneLayout());
content.add(pane);
content.add(new JTextField("some dummy") );
Action action = new AbstractAction("add row") {

    @Override
    public void actionPerformed(ActionEvent e) {
        int count = (comp.getComponentCount() +1)/ 2;
        comp.add(new JLabel("some Item: "));
        comp.add(new JTextField(count + 5));
        pane.getParent().revalidate();
    }
};
frame.add(new JButton(action), BorderLayout.SOUTH);
frame.add(content);
frame.pack();
frame.setSize(frame.getWidth()*2, frame.getHeight());
frame.setVisible(true);