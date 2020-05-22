public static void main(String[] args)
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    String columnNames[] = { "Column 1", "Column 2", "Column 3" };

    String dataValues[][] = { { "12", "234", "67" }, { "-123", "43", "853" }, { "93", "89.2", "109" }, { "279", "9033", "3092" } };
    JTable table = new JTable(dataValues, columnNames);

    panel.add(table);

    final JPopupMenu menu = new JPopupMenu();
    JMenuItem item = new JMenuItem("item");
    menu.add(item);
    table.setComponentPopupMenu(menu);

    table.addMouseListener(new MouseAdapter()
    {
        @Override
        public void mouseReleased(MouseEvent e)
        {
            if (e.isPopupTrigger())
            {
                menu.show(e.getComponent(), e.getX(), e.getY());
            }
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {
            if (e.isPopupTrigger())
            {
                menu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    });

    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);
}