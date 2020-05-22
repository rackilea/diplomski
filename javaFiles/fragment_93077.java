public @Entity class Person {

  public static enum Mood {sad, ok, happy}

  @Id Long ID;
  Mood mood;

}