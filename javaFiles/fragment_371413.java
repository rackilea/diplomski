interface IPerson {
   void doSomething();
}

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "__class")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class MyPerson implements IPerson {
    String name;

    @Override
    public void doSomething() {
    }
}