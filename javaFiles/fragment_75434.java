private void highlightReportRowsIfImportant(TextField txt_adressnummer) {
            tv_berichte.setRowFactory(new Callback<TableView<DatabaseReport>, TableRow<DatabaseReport>>() {
                @Override
                public TableRow<DatabaseReport> call(TableView<DatabaseReport> tableView) {
                    final TableRow<DatabaseReport> row = new TableRow<DatabaseReport>() {
                        @Override
                        protected void updateItem(DatabaseReport report, boolean empty) {
                            super.updateItem(report, empty);
                            if (report != null) {
                                if (report.getReport_art().contains("!!!")) {
                                    setStyle("-fx-background-color: #FF0000;");
                                } else {
                                    setStyle("");
                                }
                            } else {
                                setStyle("");
                            }
                        }
                    };
                    reports.addListener(new ListChangeListener<DatabaseReport>() {
                        @Override
                        public void onChanged(ListChangeListener.Change<? extends DatabaseReport> change) {
                            if (row.getItem() != null) {
                                if (row.getItem().getReport_art().contains("!!!")) {
                                    row.setStyle("-fx-background-color: #FF0000;");
                                } else {
                                    row.setStyle("");
                                }
                            } else {
                                row.setStyle("");
                            }
                        }
                    });

                    row.setOnDragDetected(event -> {
                        if (!row.isEmpty()) {
                            Dragboard db = row.startDragAndDrop(TransferMode.COPY);
                            db.setDragView(row.snapshot(null, null));
                            ClipboardContent cc = new ClipboardContent();
                            cc.putString(row.getItem().getReport_content());
                            db.setContent(cc);
                            event.consume();
                        }
                    });

                    row.setOnDragOver(event -> {
                        Dragboard db = event.getDragboard();
                        if (db.hasContent(DataFormat.PLAIN_TEXT)) {
                            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                            event.consume();
                        }
                    });

                    row.setOnDragDropped(event -> {
                        Dragboard db = event.getDragboard();
                        if (db.hasContent(DataFormat.PLAIN_TEXT)) {
                            reportFlowController.addNewReport(username, getSqlTimeStamp().toString(), txt_adressnummer.getText(), reports, db.getString());
                            event.setDropCompleted(true);
                            event.consume();
                        }
                    });
                    return row;
                }
            });
        }