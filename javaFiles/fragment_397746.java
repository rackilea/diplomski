public static <T> Collection<T> getBeans(String prop, Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
  Pattern pattern = Pattern.compile("^" + prop.replace(".", "\\.") + "(\\d*)\\.(\\w+)$");
  Map<String, T> beans = new TreeMap<String, T>();
  @SuppressWarnings("rawtypes")
  Map description = null;
  T tmpBean = null;
  Iterator<String> itKeys = m_propStore.getKeys();
  while (itKeys.hasNext()) {
    String key = itKeys.next();
    Matcher matcher = pattern.matcher(key);
    boolean matchFound = matcher.find();

    if (matchFound) {
      if (description == null) {
        tmpBean = clazz.newInstance();
        description = BeanUtils.describe(tmpBean);
      }

      String beanPropName = matcher.group(2);
      if (description.containsKey(beanPropName)) {
        String beanKey = matcher.group(1);
        T bean = beans.get(beanKey);
        if (bean == null) {
          bean = tmpBean == null ? clazz.newInstance() : tmpBean;
          tmpBean = null;
          beans.put(beanKey, bean);
        }
        try {
          BeanUtils.setProperty(bean, beanPropName, m_propStore.getString(key));
        } catch (Exception e) {
          m_logger.error(String.format("[SystemConfiguration]: failed to set the %s.%s bean property to the value of the %s configuration property - %s",
            bean.getClass().getName(), beanPropName, key, e.getMessage()));
        }
      }
    }
  }
  return beans.values();
}