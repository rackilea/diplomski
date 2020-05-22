@TypeDef(name="myEnumConverter", typeClass=MyEnumConverter.class)
public @Entity class Person {

  public static enum Mood {sad, ok, happy}

  @Id Long ID;
  @Type(type="myEnumConverter") Mood mood;