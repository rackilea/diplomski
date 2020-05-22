public class EntityASpecifications {
 //other specifications
 ...

   public static Specification<EntityA> entityBNameContains(String query) {
       return (root, criteriaQuery, criteriaBuilder) -> {

          if (query == null) {
              return criteriaBuilder.conjunction();
          }
          Subquery< EntityB> subquery = query.subquery(EntityB.class);
          Root< EntityB> subqueryRoot = subquery.from(EntityB.class);
          subquery.select(subqueryRoot);

          subquery.where(criteriaBuilder.and(criteriaBuilder.equal(root, subqueryRoot.get("entitya_id")),
                                criteriaBuilder.like(criteriaBuilder.lower("name"), getContainsPattern(query)))
                   );

          return criteriaBuilder.exists(subquery);

       };
   } 
   private static String getContainsPattern(String searchTerm) {
     return (searchTerm.isEmpty()) ? "%" : "%" + searchTerm.toLowerCase() + "%";
 }
}