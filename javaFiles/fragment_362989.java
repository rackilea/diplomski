public class MyTwinColSelect
    extends TwinColSelect {

   public MyTwinColSelect(List<T> dataSource, List<T> value) {
      setContainerDataSource(new BeanItemContainer<T>(dataSource));
      setValue(value);
   }

   public updateDataSource(List<T> newDataSource) {
      setContainerDataSource(new BeanItemContainer<T>(newDataSource));
   }
}