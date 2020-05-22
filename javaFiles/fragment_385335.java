public Object getProperty(String propertyName) {
  if(propertyName.equals(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS)) {
    return new String[] {"mycustom.rest.security.SecurityProvider"};
  } else {
    return super.getProperty(propertyName);
  }
}

public Map<String,Object> getProperties() {
  propName = ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS;
  Map<String,Object> result = super.getProperties();
  result.put(propName,getProperty(propName));
  return result;
}