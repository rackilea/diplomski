sourceColumn.setCellFactory(new Callback<TableColumn<SourceItem, SourceItem>,TableCell<SourceItem, SourceItem>>(){

        public TableCell<SourceItem, SourceItem> call(TableColumn<SourceItem, SourceItem> param){

            TableCell<SourceItem, SourceItem> cell = new TableCell<SourceItem, SourceItem>(){

                @Override
                public void updateItem(SourceItem item, boolean empty) {

                    if (!empty) {
                        HBox box = new HBox();
                        box.setAlignment(Pos.CENTER_LEFT);
                        Region spacer = new Region();
                        HBox.setHgrow(spacer, Priority.ALWAYS);

                        box.getChildren().addAll(item.getLabel(), spacer);

                        if (item instanceof ShareSourceItem) {
                            if (((ShareSourceItem)item).isResolving()) {
                                box.getChildren().addAll(loadImage(mediaPath+"loader2.gif"));
                            }
                        }

                        setGraphic(box);
                    }
                }
            };
            return cell;
        }

    });