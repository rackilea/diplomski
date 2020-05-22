public class Product {
    Long id;
    String description;
    Set<Rating> ratings;
}
public class Rating{
    Long id;
    Integer stars;
    String comments;
    User user;
    Product product;
}
public class User {
    ...
}