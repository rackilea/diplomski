ConfigurablePropertyAccessor fieldAccessor = new DirectFieldAccessor (someObject);
beanWrapper.setPropertyValue(fieldName, 
   fieldAccessor.convertForProperty(value, fieldName) );


ConfigurablePropertyAccessor beanWrapper = new BeanWrapperImpl(someObject);
beanWrapper.setPropertyValue(propertyName, 
   beanWrapper.convertForProperty(value, propertyName) );