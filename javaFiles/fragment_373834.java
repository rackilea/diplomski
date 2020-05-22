if (value instanceof File) {
   File file = (File) value;
   return super.getListCellRendererComponent(list, file.getName(), index, isSelected, cellHasFocus);
} else {
   return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
}