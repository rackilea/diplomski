A someBean = new A();

// access properties as Map
Map<String, Object> properties = BeanUtils.describe(someBean);
properties.set("name","Fred");
BeanUtils.populate(someBean, properties);

// access individual properties
String oldname = BeanUtils.getProperty(someBean,"name");
BeanUtils.setProperty(someBean,"name","Barny");