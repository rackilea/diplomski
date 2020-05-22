TableViewerColumn c1 = new TableViewerColumn(tableViewer, tableViewerStyle);
        c1.setLabelProvider(new CellLabelProvider() {
            @Override
            public void update(ViewerCell cell) {
            }
        });
        c1.getColumn().setWidth(200);
        c1.setEditingSupport(new FirstNameEditingSupport(tableViewer));