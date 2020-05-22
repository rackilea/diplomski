private SomeObject someObjectInstance = null;

public synchronized List<ConfigurableObjects> createObjects() {
  List<ConfigurableObjects> objects = new ArrayList<ConfigurableObjects>();
  if (someObjectInstance = null)
  {
    someObjectInstance = (SomeObject)beanFactory.getBean(SomeObject.class.getName());        
  }

  objects.add(someObjectInstance);
  return objects;
}