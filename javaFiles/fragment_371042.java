public class EntitySpecifications {
    public static Specification<Entity> firstIdEquals(Optional<Long> firstId) {// or Long firstId. It is better to avoid Optional method parameters.
        return (root, query, builder) -> 
            firstId.isPresent() ? // or firstId != null if you use Long method parameter
            builder.equal(root.get("firstId"), firstId.get()) :
            builder.conjunction(); // to ignore this clause
    }

    public static Specification<Entity> secondIdEquals(Optional<Long> secondId) {
        return (root, query, builder) -> 
            secondId.isPresent() ? 
            builder.equal(root.get("secondId"), secondId.get()) :
            builder.conjunction(); // to ignore this clause
    }
}