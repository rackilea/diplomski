public class KundenwertCellFactory implements Callback<TableColumn<ProfilZuordnungTableRowModel, Double>, TableCell<ProfilZuordnungTableRowModel, Double>> {

    public TableCell<ProfilZuordnungTableRowModel, Double> call(TableColumn<ProfilZuordnungTableRowModel, Double> param) {
        TableCell<ProfilZuordnungTableRowModel, Double> cell = new TableCell<ProfilZuordnungTableRowModel, Double>() {

            @Override
            public void updateItem(final Double item, boolean empty) {
                if (item != null) {
                    setText(item.toString()); // you can format your value here
                }
            }
        };
        return cell;
    }
}