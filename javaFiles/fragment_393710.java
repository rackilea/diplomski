Constructor c = new Constructor(MyClass.class);
c.setPropertyUtils(new PropertyUtils() {
    @Override
    public Property getProperty(Class<? extends Object> type, String name) throws IntrospectionException {
      if ( name.indexOf('-') > -1 ) {
        name = toCameCase(name);
      }
      return super.getProperty(type, name);
    }
  });
Yaml yaml = new Yaml(c);
MyClass obj = (MyClass) yaml.load(input);