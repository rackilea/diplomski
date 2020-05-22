JTable table = new JTable(rowData, headerData)
{
    private static final int DESIRED_WIDTH = 400;

    Dimension dim = new Dimension(DESIRED_WIDTH, Integer.MAX_VALUE);

    {
        JScrollPane dummy = new JScrollPane(this);
        dummy.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JFrame frame = new JFrame();
        frame.add(dummy);
        frame.pack();
        int actualWidth = dummy.getSize().width;
        frame.dispose();
        int excess = actualWidth - DESIRED_WIDTH;
        dim = new Dimension(DESIRED_WIDTH - excess, getRowHeight() * 3);
    }

    public Dimension getPreferredScrollableViewportSize()
    {
        return dim;
    }
};