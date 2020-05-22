public class CustomerSpecification implements Specification<Customer> {

    // names of the fields in your Customer entity
    private static final String CONST_EMAIL_ID = "emailId";
    private static final String CONST_MOBILE = "mobile";

    private List<MyTuple> tuples;

    public ClaimSpecification(List<MyTuple> tuples) {
        this.tuples = tuples;
    }

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        // will be connected with logical OR
        List<Predicate> predicates = new ArrayList<>();

        tuples.forEach(tuple -> {
            List<Predicate> innerPredicates = new ArrayList<>();
            if (tuple.getEmail() != null) {
                 innerPredicates.add(cb.equal(root
                     .<String>get(CONST_EMAIL_ID), tuple.getEmail()));
            }
            if (tuple.getMobile() != null) {
                 innerPredicates.add(cb.equal(root
                     .<String>get(CONST_MOBILE), tuple.getMobile()));
            }
            // these predicates match a tuple, hence joined with AND
            predicates.add(andTogether(innerPredicates, cb));
        });

        return orTogether(predicates, cb);
    }

    private Predicate orTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.or(predicates.toArray(new Predicate[0]));
    }

    private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
        return cb.and(predicates.toArray(new Predicate[0]));
    }
}