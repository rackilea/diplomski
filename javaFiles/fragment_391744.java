public class ScrollListExample {
    static List<String> stringList = new ArrayList<String>();
    static {
        for (int i = 0; i < 500; i++) {
            stringList.add("test" + i);
        }
    }

    public static void main(final String[] args) {
        final JFrame frame = new JFrame();
        final Container contentPane = frame.getContentPane();
        final JList list = new JList(stringList.toArray());
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        final JScrollPane scrollPane = new JScrollPane(list);
        contentPane.add(scrollPane);
        frame.setPreferredSize(new Dimension(800, 400));
        frame.pack();

        list.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                fixRowCountForVisibleColumns(list);
            }
        });

        fixRowCountForVisibleColumns(list);
        frame.setVisible(true);
    }

    private static void fixRowCountForVisibleColumns(JList list) {
        int nCols = computeVisibleColumnCount(list);
        int nItems = list.getModel().getSize();

        // Compute the number of rows that will result in the desired number of
        // columns
        int nRows = nItems / nCols;
        if (nItems % nCols > 0) nRows++;
        list.setVisibleRowCount(nRows);
    }

    private static int computeVisibleColumnCount(JList list) {
        // It's assumed here that all cells have the same width. This method
        // could be modified if this assumption is false. If there was cell
        // padding, it would have to be accounted for here as well.
        int cellWidth = list.getCellBounds(0, 0).width;
        int width = list.getVisibleRect().width;
        return width / cellWidth;
    }
}