table.setMultiSelect(true);
BeanItemContainer<Analyte> container = new BeanItemContainer<Analyte>(Analyte.class);
container.addAll(Arrays.asList(Analyte.getAnalytes()));
table.setContainerDatasource(container);
// Add some Properties of Analyte class that you want to be shown to user
table.setVisibleColumns(new Object[]{"ID","Analyte Name"});


//User selects Multiple Values, mind you this is an Unmodifiable Collection
Set<Analyte> selectedValues = (Set<Analyte>)table.getValue();