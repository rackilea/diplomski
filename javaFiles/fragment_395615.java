public void bar() {
   ...
   tpl.execute // or whatever
  }
}


@Service // this is a spring managed service
class MyService {
  @Autowired // or constructor injection, doesn't matter for the sake of this example
  private JdbcTemplate tpl;

  public void foo() {
       NonManagedBySpring  obj = new NonManagedBySpring (tpl);
       obj.bar();
  }    
}