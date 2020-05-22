columns.add(new PropertyColumn(new Model("Status"), "code") {
        private static final long serialVersionUID = 1L;
        @Override
        public void populateItem(Item item, String componentId, IModel model) {
            Object[] values = ((ArrayWrapper) model.getObject()).getArray();
            setStatus((Integer) values[0]);
            item.add(new ImagePanel(componentId, new ResourceReference(SearchResults.class, getStatus())));
        }
    });