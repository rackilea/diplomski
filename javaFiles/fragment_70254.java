public class ShipperAgentGUI extends JFrame implements ActionListener {

    // ... bla bla

    private COLUMNS[] parkModelHeader = {COLUMNS.IMAGE_COLUMN, COLUMNS.TARGA_COLUMN,
        COLUMNS.CAR_TYPE_COLUMN, COLUMNS.MARCA_COLUMN, COLUMNS.STATE_COLUMN, COLUMNS.PTT_COLUMN };
    private VehicleTableModel parkModel = new VehicleTableModel(parkModelHeader);
    private VehicleTable parkTable; 
    private Coordinator parkCoordinator; // long story

    protected ShipperAgent shipperAgent; // my agent, my third-part software

    // ... bla bla

    // Constructor:
    ShipperAgentGUI(ShipperAgent agent) {

        //... bla bla

        // Park Table:
        parkTable = new VehicleTable(parkModel);
        JScrollPane parkScrollPane = new JScrollPane(parkTable);
        pnlTableParkPanel.add(parkScrollPane);

        //... bla bla

        // Coordinators (Mediator pattern's ispired)
        // Long story. Is for coordinating with my agent and others tables in my GUI
        parkCoordinator = new Coordinator(shipperAgent, parkModel) {

            @Override
            public void notifyAndAddRow(final Vehicle vehicle) {
                shipperAgent.newTruck(vehicle.getTarga()); // comunicate with the agent

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        parkModel.addRow(vehicle);
                    }
                });
            }

            @Override
            public void notifyAndDeleteRow(final int rowIndex) {
                final Vehicle v = this.tableModel.getVehicleAt(rowIndex);
                // bla bla
                shipperAgent.removeTruck(v.getTarga()); // comunicate with the agent

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        //parkModel.removeRow(v);
                        parkModel.removeRow(rowIndex);
                    }
                });
            }
@Override
public void notifyRowUpdated() {
    parkModel.addTableModelListener(new TableModelListener() {
        public void tableChanged(TableModelEvent e) {
            switch (e.getType()) {
                case (TableModelEvent.DELETE):
                    parkTable.repaint();
                    break;
                case (TableModelEvent.UPDATE):
                    int row = e.getLastRow();
                    int col = parkModel.getIndexColumn(COLUMNS.STATE_COLUMN);
                    if (parkModel.getValueAt(row, col).equals(Stato.DISPONIBILE))
                        addVehicle(availablesCoordinator, parkModel.getVehicleAt(row));
                    else
                        //removeVehicle(availablesCoordinator, row); error!
                        availablesModel.removeRow(parkModel.getVehicleAt(row));
                    repaint();
                    break;
            }
        }
    });
}
        };


        ArrayList<Vehicle> veicoli = shipperAgent.getVehicles(); // from agent
        Iterator<Vehicle> I = veicoli.iterator();
        while (I.hasNext()){
            addVehicle(parkCoordinator, I.next());
        }

        //... bla bla

    } // end of constructor

    // ... others methods...

    private void addVehicle(Coordinator coordinator, Vehicle v) {
        coordinator.notifyAndAddRow(v);
    }

    public void removeVehicle(Coordinator coordinator, int index) {
        coordinator.notifyAndDeleteRow(index);
    }

    // ...

}