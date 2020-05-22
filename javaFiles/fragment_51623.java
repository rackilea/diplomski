import play.data.validation.Constraints;
...

class Example{
  @Constraints.Required public String name;
  @Constraints.Required public boolean dead;
  @Constraints.Required public Integer age;
  .
  .
  50 more values
}