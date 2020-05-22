public class VehicleTable extends JTable {

public VehicleTable(VehicleTableModel vehicleModel) {
    super(vehicleModel); 
    this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    this.setColumnSelectionAllowed(false);
    this.setCellSelectionEnabled(false);
    this.setRowSelectionAllowed(true);
    this.setShowHorizontalLines(true);
    this.setRowHeight(25);
    this.setPreferredScrollableViewportSize(new Dimension(700,150));
    this.setFillsViewportHeight(true);

    ////////////////////////////////////
    // Now I set the columns features:
    int flag=-1;
    TableColumn column;

    // Icon Column:
    flag = vehicleModel.findColumn(COLUMNS.IMAGE_COLUMN);
    if (flag!=-1){
        column = this.getColumnModel().getColumn(flag);
        column.setMinWidth(80);
        column.setMaxWidth(80);
    }

    // Targa Column:
    flag = vehicleModel.findColumn(COLUMNS.TARGA_COLUMN);
    if (flag!=-1){
        column = this.getColumnModel().getColumn(flag);
        column.setMinWidth(100);
        column.setMaxWidth(100);
    }

    // Tipo veicolo Column
    flag = vehicleModel.findColumn(COLUMNS.CAR_TYPE_COLUMN);
    if (flag!=-1){
        column = this.getColumnModel().getColumn(flag);
        column.setCellEditor(new DefaultCellEditor(
                new JComboBox<TipoVeicolo>(TipoVeicolo.values())));
        column.setMinWidth(150);
        column.setMaxWidth(150);
    }

    //others...
}