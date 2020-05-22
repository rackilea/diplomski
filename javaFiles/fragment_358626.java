ThreadLocal<MyClass> local = new ThreadLocal<MyClass>();

// later
if (local.get() == null) {
  local.put(new MyClass());
}
MyClass myClass = local.get();