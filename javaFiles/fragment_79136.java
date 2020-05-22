public class StationListWorker extends SwingWorker<Void, Object[]> {
    // The data to be processed...
    private List<Station> stations;
    // The model the results are to be published to...
    private DefaultTableModel model;
    public StationListWorker(List<Station> stations, DefaultTabelModel model) {
        this.stations = stations;
        this.model = model;
    }

    protected Void doInBackground() throws Exception {
        // Process the data in the background thread...
        for (Station station : stations) {
            // Process the data...
            publish(new Object[]{...});
        }
        return null;
    }

    protected void publish(List<Object[]> rows) {
        // Published in the EDT
        for (Object[] row : rows) {
            model.addRow(row);
        }
    }
}