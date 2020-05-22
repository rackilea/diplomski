public static <T extends SomeUiClass> AddEntryWindow<T> createAddEntryWindow(TableDefinition tableDefinition, RefreshListener refreshListener, Class<T> c){
    if(PartUiClass.class.isAssignableFrom(c)){
        return (AddEntryWindow<T>) new AddPartWindow(tableDefinition, refreshListener);
    }
    return new AddEntryWindow<>(tableDefinition, refreshListener);
}