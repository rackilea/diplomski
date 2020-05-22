table.setRowFactory(t -> {
            final TableRow tr = new TableRow();
            final double prefHeight = 54;
            tr.setPrefHeight(prefHeight);

            tr.setOnMouseDragged(event -> {
                final double newHeight = event.getY();
                if(newHeight < prefHeight) {
                    return;
                }
                tr.setPrefHeight(newHeight);
                tr.autosize();
            });

            return tr;

        });