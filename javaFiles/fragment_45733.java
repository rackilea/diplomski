public class ImageTableModel extends AbstractTableModel {

    private List<ImageProperty> images;

    public ImageTableModel() {
        images = new ArrayList<ImageProperty>(25);
    }

    @Override
    public int getRowCount() {
        return images.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        String name = "";
        switch (column) {
            case 1:
                name = "Path";
                break;
            case 2:
                name = "Name";
                break;
            case 3:
                name = "Size";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnIndex == 0 ? Boolean.class : String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ImageProperty row = images.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = row.isSelected();
                break;
            case 1:
                value = row.getSource().getParent();
                break;
            case 2:
                value = row.getSource().getName();
                break;
            case 3:
                value = row.getSize().width + "x" + row.getSize().height;
                break;
        }
        return value;
    }

    public void addImage(ImageProperty image) {

        images.add(image);
        fireTableRowsInserted(images.size() - 1, images.size() - 1);

    }

    public void addImages(List<ImageProperty> newImages) {

        int firstRow = images.size();
        int lastRow = firstRow + newImages.size() - 1;

        images.addAll(newImages);
        fireTableRowsInserted(firstRow, lastRow);

    }

    public void clear() {

        int lastRow = images.size() -1;
        images.clear();
        fireTableRowsDeleted(0, lastRow);

    }

}