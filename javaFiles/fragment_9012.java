public class SensorTableModel extends AbstractTableModel {

    protected static final String[] COLUMN_NAMES = {
        "TIME",
        "SENSORID",
        "TEMP",
        "HUM",
        "LIGHT",
        "VOLTAGE"
    };

    private List<Sensor> sensors;

    public SensorTableModel(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public int getRowCount() {
        return sensors.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sensor sensor = sensors.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = sensor.getTime();
                break;
            case 1:
                value = sensor.getID();
                break;
            case 2:
                value = sensor.getTemp();
                break;
            case 3:
                value = sensor.getHum();
                break;
            case 4:
                value = sensor.getLight();
                break;
            case 5:
                value = sensor.getVoltage();
                break;
        }
        return value;
    }
}