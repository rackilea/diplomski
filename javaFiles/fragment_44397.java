@Value
public class ModelFilter implements Specification<Model> {

    private String name;
    private String createdAt;

    PredicateBuilder<Model> eq = ... ;
    PredicateBuilder<Model> like = ... ;
    PredicateBuilder<Model> sw = ... ;
    PredicateBuilder<Model> between = ... ;
    PredicateBuilder<Model> from = ... ;
    PredicateBuilder<Model> to = ... ;

    @Override
    public Predicate toPredicate(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        if (name != null) {
            eq.get("name", name, root, builder).ifPresent(predicates::add);
            like.get("name", name, root, builder).ifPresent(predicates::add);
            sw.get("name", name, root, builder).ifPresent(predicates::add);
        }

        if (createdAt != null) {
            between.get("createdAt", createdAt, root, builder).ifPresent(predicates::add);
            from.get("createdAt", createdAt, root, builder).ifPresent(predicates::add);
            to.get("createdAt", createdAt, root, builder).ifPresent(predicates::add);
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}