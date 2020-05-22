bg = DefaultLookup.getColor(this, ui, "List.dropCellBackground");
    fg = DefaultLookup.getColor(this, ui, "List.dropCellForeground");

if (isSelected) {
    setBackground(bg == null ? list.getSelectionBackground() : bg);
    setForeground(fg == null ? list.getSelectionForeground() : fg);
}
else {
    setBackground(list.getBackground());
    setForeground(list.getForeground());
}