public class MyCustomBindings extends SimpleBindings {

@Override
public Object put(String name, Object value) {
  Object result = super.put(name, value);
  // "setter" logic
  return result;
}

@Override
public Object get(Object key) {
  // "getter" logic
  return super.get(key);
}