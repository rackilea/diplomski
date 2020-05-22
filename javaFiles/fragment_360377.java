// Note here! This is your DSL entry point. Choose wisely whether you want
// this to be a static or instance method.
// - static: less verbose in client code
// - instance: can inherit factory state, which is useful for configuration
public class Factory {

  // Varargs implicitly means connecting predicates using Predicate.and()
  public static Query query(Predicate... predicates);

}