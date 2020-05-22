public class MyIndexedListClass {
    private List<String> myIndexedListClass = new ArrayList<String>();

    public String getMyIndexedListClass(int index) {
        return myIndexedListClass.get(index);
    }
    public void setMyIndexedListClass(int index, String element) {
        this.myIndexedListClass.set(index, element);
    }
    public List<String> getMyIndexedListClass() {
        return myIndexedListClass;
    }
    public void setMyIndexedListClass(List<String> myIndexedListClass) {
        this.myIndexedListClass = myIndexedListClass;
    }
}
static // in your example all classes are inner classes
public class MyIndexedListClassBeanInfo extends SimpleBeanInfo {
  private PropertyDescriptor[] properties;

  public MyIndexedListClassBeanInfo() throws IntrospectionException {
    PropertyDescriptor[] p=Introspector.getBeanInfo(MyIndexedListClass.class,
        Introspector.IGNORE_IMMEDIATE_BEANINFO).getPropertyDescriptors();
    ArrayList<PropertyDescriptor> list=new ArrayList<>(p.length+1);
    for(PropertyDescriptor d: p)
      if(!d.getName().equals("myIndexedListClass")) list.add(d);
    list.add(new IndexedPropertyDescriptor("myIndexedListClass",
        MyIndexedListClass.class, null, null,
        "getMyIndexedListClass", "setMyIndexedListClass"));
    properties=list.toArray(new PropertyDescriptor[list.size()]);
  }

  @Override
  public PropertyDescriptor[] getPropertyDescriptors() {
      return properties;
  }
}