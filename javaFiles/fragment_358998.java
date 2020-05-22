@Component
public class UserDetailsFacade {

  private final EntityManager entityManager;

  public UserDetailsFacade(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  public AggregatedUserDetails aggregatedUserDetails() {
    return aggregatedUserDetails(null);
  }

  @Transactional(readOnly = true)
  public AggregatedUserDetails aggregatedUserDetails(Specification<User> userSpecification) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<AggregatedUserDetails> query = criteriaBuilder.createQuery(AggregatedUserDetails.class);
    Root<User> from = query.from(User.class);

    Predicate predicate = null;

    if ( userSpecification != null )
      predicate = userSpecification.toPredicate(from, query, criteriaBuilder);

    CompoundSelection<AggregatedUserDetails> construct = criteriaBuilder.construct(
        AggregatedUserDetails.class,
        criteriaBuilder.sum(from.get("salary")),
        criteriaBuilder.avg(from.get("age")),
        criteriaBuilder.sum(from.get("children"))
    );

    CriteriaQuery<AggregatedUserDetails> select = query.select(construct);

    if ( predicate != null )
      select.where(predicate);

    return entityManager.createQuery(select).getSingleResult();
  }
}