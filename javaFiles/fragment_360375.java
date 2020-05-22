public interface Predicate {

  // Infix notation (usually a lot more readable than the prefix-notation)
  Predicate and(Predicate... predicate);
  Predicate or(Predicate... predicate);

  // Postfix notation
  Predicate not();

  // Optionally, for convenience, add these methods:
  Predicate andNot(Predicate... predicate);
  Predicate orNot(Predicate... predicate);
}

public class Factory {

  // Prefix notation
  public static Predicate not(Predicate predicate);
}