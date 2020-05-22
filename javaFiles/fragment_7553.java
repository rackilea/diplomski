public static <T> void priceCellFormatting(TableColumn<T, Double> tableColumn){
    System.out.println();

    tableColumn.setCellFactory(col ->
        new TableCell<T, Double>() {

            @Override
            protected void updateItem(Double item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setText(null);
                }else {
                    setText(String.format("%.2f €", item));
                }


            }
        });

}