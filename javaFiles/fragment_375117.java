final ListSelect ls = new ListSelect ();
final BeanItemContainer<ObjectToDisplay> container = new BeanItemContainer<>(ObjectToDisplay.class, objectList);
ls.setContainerDataSource(container);
for (final ObjectToDisplay o : objectList){
    ls.setItemCaption(o, yourDesiredFormatFunction(o));
}