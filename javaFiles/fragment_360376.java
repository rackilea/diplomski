// Prefix notation
public class Factory {
  public static Query union(Query... queries);
}

// Infix notation
public interface Query {
  Query union(Query... queries);
}