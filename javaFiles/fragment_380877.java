for (Object record : result) {
    Object[] fields = (Object[]) record;
    String id = (String) fields[0];
    String name = (String) fields[1];
    System.out.printf("id: %s, name: %s%n", id, name);
}