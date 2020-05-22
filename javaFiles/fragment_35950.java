public class TravelSpecification implements Specification<Travel> {

    private final Travel criteria;

    public TravelSpecification(Travel criteria) {
        this.criteria=criteria;
    }

    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        // create query/predicate here.
    }
}