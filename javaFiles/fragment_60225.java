Class<?> fields = emp.getClass().getSuperclass();

for (Field field : fields.getDeclaredFields()) {
  field.setAccessible(true);             
  System.out.println(field.getName() + "\t" + field.get(emp));
}