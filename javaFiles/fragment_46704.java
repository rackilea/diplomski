tableColumnLocation.setCellFactory(
                     new Callback<TableColumn<Target, String>, TableCell<Target, String>>() {

                         @Override
                         public TableCell<Target, String> call(TableColumn<Target, String> paramTableColumn) {
                             return new ComboBoxTableCell<Target, String>(new DefaultStringConverter(), locationValues) {
                                 @Override
                                 public void updateItem(String s, boolean b) {
                                     super.updateItem(s, b);
                                     if(!isEmpty()) {
                                         Target item = getTableView().getItems().get(getIndex());
                                         if (check if checkbox is unselected) {
                                             setDisable(true);
                                             setEditable(false);
                                             this.setStyle("-fx-background-color: lightgrey");
                                         } else {
                                             setDisable(false);
                                             setEditable(true);
                                             setStyle("");
                                         }
                                     }
                                 }
                             };
                         }

                     });