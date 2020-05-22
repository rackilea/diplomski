@Value
public class ModelFilter implements Specification<Model> {

    private String name;
    private String createdAt;

    @Override
    public Predicate toPredicate(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        // Prepare predicates and fill the list with them...

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}