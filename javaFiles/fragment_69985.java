class TimeColumnRenderer extends DefaultTableCellRenderer {
    public TimeColumnRenderer() {
        setHorizontalAlignment(SwingConstants.TRAILING);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        int time = Integer.parseInt(value.toString());
        time = time > 12 ? time % 12 : time;
        String timeText = String.format("%d:00", time);
        return super.getTableCellRendererComponent(table, timeText, isSelected, hasFocus, row, column);
    }
}