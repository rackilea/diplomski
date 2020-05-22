Container container = table.getContainerDataSource();      
  if (container instanceof IndexedContainer) {
    ((IndexedContainer) container).setItemSorter(itemSorter);
  } else if (container instanceof AbstractBeanContainer){
    ((AbstractBeanContainer) container).setItemSorter(itemSorter);
  }