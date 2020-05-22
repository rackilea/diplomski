public class VehicleTableModel extends AbstractTableModel {

    // private objects
    private ArrayList<Vehicle> vehicles;
    private COLUMNS[] header;

    // possible column names:
    public enum COLUMNS {
        IMAGE_COLUMN,
        TARGA_COLUMN,
        CAR_TYPE_COLUMN,
        //...
    }; // if I want I can add others...



    ///////////////////////////////////////////////////////
    // Constructor:

    public VehicleTableModel(COLUMNS[] headerTable) {
        this.vehicles = new ArrayList<Vehicle>()
        this.header = headerTable;
    }


    ///////////////////////////////////////////////////////
    // obligatory override methods (from AbstractTableModel):

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public int getRowCount() {
        return vehicles.size();
    }

    // this works! :D
    @Override
    public Object getValueAt(int row, int col) {
        Object value = "?";
        Vehicle v = vehicles.get(row);
        if (v!=null) {
            COLUMNS column = header[col];
            switch (column) {
                case IMAGE_COLUMN:
                    int i = findColumn(COLUMNS.CAR_TYPE_COLUMN); // find the right column index
                    Object tipo = getValueAt(row, i); 
                    value = (ImageIcon)findImageByColumnCarType(tipo); // find the right icon for the type of vehicle.
                    break;
                case TARGA_COLUMN:
                    value = v.getTarga();
                    break;
                case CAR_TYPE_COLUMN:
                    value = v.getTipoVeicolo();
                    break;
                //...
            }
        }
        return value;
    }



    ///////////////////////////////////////////////////////
    // My methods:

    public void addRow(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)){
            vehicles.add(vehicle);
            fireTableRowsInserted(0, getRowCount()); // I'm not so sure of this..
    }

    /* I'm not so sure of this..
    public boolean removeRow(Vehicle vehicle) {
        boolean flag = vehicles.remove(vehicle);
        fireTableRowsDeleted(0, getRowCount()); // or fireTableDataChanged(); ?
        return flag;
    }*/

    public void removeRow(int row) {
        vehicles.remove(row);
        fireTableRowsDeleted(row, row);
    }


    public Vehicle getVehicleAt(int row) {
        return vehicles.get(row);
    }

    // found the corresponding column index
    public int findColumn(COLUMNS columnName) {
        for (int i=0; i<getColumnCount(); i++)
            if (columnName.equals(header[i])) 
                return i;
        return -1;
    }

    // found the right image
    protected static ImageIcon findImageByColumnCarType(Object value) {
        ImageIcon i = null;
        if (value.equals(TipoVeicolo.AUTO))
            i = new ImageIcon(VehicleTableModel.class.getResource("/images/Car-icon_32.png"));
        else if (value.equals(TipoVeicolo.AUTOARTICOLATO))
            i = new ImageIcon(VehicleTableModel.class.getResource("/images/City-Truck-blue-icon_32.png"));
        //...
        return i;
    }

    // knows if exist a value (of a column) in all rows
    private boolean controllIfExist(Object value, int col) {
        boolean bool = false;
        for (int i=0; i<getRowCount();i++){
            if (value.equals(getValueAt(i, col))){
                bool=true;
                break;
            }
        }
        return bool;
    }



    ///////////////////////////////////////////////////////
    // other methods (from AbstractTableModel) to ovveride:

    // this works! :D
    @Override
    public Class<?> getColumnClass(int col) {
        Class<?> c;
        COLUMNS column = header[col];
        if (column.equals(COLUMNS.IMAGE_COLUMN))
            c = ImageIcon.class;
        else if (column.equals(COLUMNS.CAR_TYPE_COLUMN))
            c =  JComboBox.class;
        // else if blabla....
        else c = super.getColumnClass(col);
        return c;
    }

    // this works! :D 
    @Override
    public String getColumnName(int col) {
        COLUMNS column = header[col];
        if (column.equals(COLUMNS.IMAGE_COLUMN))
            return " ";
        else if (column.equals(COLUMNS.TARGA_COLUMN))
            return "Targa";
        else if (column.equals(COLUMNS.CAR_TYPE_COLUMN))
            return "Tipo veicolo";
        // else if blabla...
        return super.getColumnName(col);
    };


    @Override
    public boolean isCellEditable(int row, int col) {
        return true;
    }


    @Override
    public void setValueAt(Object value, int row, int col) {
        Vehicle v = vehicles.get(row);
        boolean flag = false;
        if (v!=null) {
            COLUMNS column = header[col];
            switch (column) {
                case TARGA_COLUMN:
                    if (!v.getTarga().equals(value)){
                        if (!controllIfExist(value, col)){
                            v.setTarga((String) value);
                            flag = true;
                        }
                    }
                    break;
                case CAR_TYPE_COLUMN:
                    if (!v.getTipoVeicolo().equals(value)){
                        v.setTipoVeicolo((TipoVeicolo) value);
                        flag = true;
                    }
                    break;
                // other cases bla bla...
            }

            if (flag) // update only if have found modify
                fireTableRowsUpdated(0, getRowCount()); // or fireTableRowsUpdated(row, row); ?
        }
    }

}