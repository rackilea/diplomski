public static void main(String[] args) {
  MyImmutableClass c = new MyImmutableClass(new Person("OriginalName"));
  System.out.println(c);
  c.setPersonName("AlteredName");
  System.out.println(c);
}