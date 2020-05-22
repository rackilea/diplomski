Field[] fields = Test1.getDeclaredFields();

for (Field field : fields) {
  if (field.getType().equals(WeakReference.class) {
    System.out.println(field.getName());
  }
}