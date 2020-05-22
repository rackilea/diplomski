Field[] fields = ApplicationProperties.class.getDeclaredFields();
AccessibleObject.setAccessible(fields, true);
for(Field f : fields){
    Object v = f.get(applicationProperties);
    Path p = Files.createDirectories(Paths.get(v.toString()));
    System.out.println(p.toAbsolutePath());
}