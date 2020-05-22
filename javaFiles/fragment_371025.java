new Table() {

    @Override
    public void setVisibleColumns(Object... visibleColumns) {
        super.setVisibleColumns(visibleColumns);
        for (Object propertyId : visibleColumns) {
            setPropertyAlignment(propertyId);
        }
    }

    private void setPropertyAlignment(Object propertyId) {

        Class<?> clazzProperty = getContainerDataSource().getType(propertyId);
        if (clazzProperty.isAssignableFrom(Number.class)) {
            super.setColumnAlignment(propertyId, Align.RIGHT);
        }
        else {
            super.setColumnAlignment(propertyId, Align.LEFT);
        }

    }
}