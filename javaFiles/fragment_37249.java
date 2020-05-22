static class ListRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList chartList, Object
        value, int index, boolean isSelected, boolean cellHasFocus) {
        ChartPanel chartPanel = (ChartPanel) value;
        if (isSelected) {chartPanel.getChart().setBackgroundPaint(Color.red);}
        else {chartPanel.getChart().setBackgroundPaint(Color.white);}
        return chartPanel;
    }
}