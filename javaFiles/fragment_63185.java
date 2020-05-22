class VolumeTableModel extends AbstractTableModel {
    private String[] columnNames = {"Nr:", "Volume Name", "TotalSize [MB]", "Used [MB]", "Status"};
    private ArrayList<Volume> volumes;

    public VolumeTableModel(ArrayList<Volume> volumes) {
        this.volumes = volumes;
    }

    public VolumeTableModel() {
        volumes = new ArrayList<Volume>();
    }

    public void addVolume(Volume volume) {
        volumes.add(volume);
        fireTableRowsInserted(volumes.size()-1, volumes.size()-1);
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return volumes.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Volume volume = volumes.get(row);
        switch (col) {
            case 0: return volume.number;
            case 1: return volume.name;
            case 2: return volume.totalSize;
            case 3: return volume.usedSize;
            case 4: return volume.status;
            default: return null;
        }
    }

    public Class getColumnClass(int col) {
        return String.class;
        //or just as example
        switch (col) {
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return Integer.class;
            case 3: return Integer.class;
            case 4: return String.class;
            default: return String.class;
        }
    }
}