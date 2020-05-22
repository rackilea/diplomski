@Override
  public ObjectName getObjectName(Object managedBean, String beanKey) throws MalformedObjectNameException {
     Class managedClass = AopUtils.getTargetClass(managedBean);
     Hashtable<String, String> properties = new Hashtable<String, String>();
     properties.put("type",ClassUtils.getPackageName(managedClass).concat(".").concat(ClassUtils.getShortName(managedClass)));
     properties.put("name", beanKey);
     return ObjectNameManager.getInstance(domain, properties);
  }