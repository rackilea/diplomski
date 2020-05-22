public class CarModel extends AbstractTableModel {

    private String[] columnNames = { "Make", "Model", "LicenseNumber", "Color",
        "Year", "HorsePower", "TimeUntilService",
        "ConsumptionPerKm", "NumberOfSeats", "NumberOfDoors",
        "ClimateControl" };

    private CarList carList;

    public CarModel(CarList list) {
        carList = list;
    }

    public CarList getCarList() {
        return carList;
    }

    @Override
    public int getRowCount() {
        return getCarList().getNumberOfCars();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
                type = String.class;
                break;
            // ...etc...
        }
        return type;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Car car = getCarList().getCarAt(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = car.getMake();
                break;
            //...etc...
        }
        return value;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }             
}