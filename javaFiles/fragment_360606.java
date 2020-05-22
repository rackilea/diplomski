public class MyCellRenderer implements ListCellRenderer {

    private JPanel p;
    private JPanel iconPanel;
    private JLabel l;
    private JTextArea ta;

    public MyCellRenderer() {
        p = new JPanel();
        p.setLayout(new BorderLayout());

        // icon
        iconPanel = new JPanel(new BorderLayout());
        l = new JLabel("icon"); // <-- this will be an icon instead of a
                                // text
        iconPanel.add(l, BorderLayout.NORTH);
        p.add(iconPanel, BorderLayout.WEST);

        // text
        ta = new JTextArea();
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        p.add(ta, BorderLayout.CENTER);
    }

    @Override
    public Component getListCellRendererComponent(final JList list,
            final Object value, final int index, final boolean isSelected,
            final boolean hasFocus) {

        ta.setText((String) value);
        int width = list.getWidth();
        // this is just to lure the ta's internal sizing mechanism into action
        if (width > 0)
            ta.setSize(width, Short.MAX_VALUE);
        return p;

    }
}