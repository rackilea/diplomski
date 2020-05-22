CriteriaBuilder cb = ...
CriteriaQuery<String> query = cb.createQuery(String.class);
Root<User> user = query.from(User.class);
SetJoin<User, Role> userRolesJoin = user.join(User_.roles);
Path<String> roleIdPath = userRolesJoin.get(User_.id);

Subquery<String> subquery = query.subquery(String.class);
Root<Role2> role2Root = subquery.from(Role2.class);
Join<Role2, SomeEntity> someEntityJoin = role2Root.join(Role2_.someEntity);
Path<String> someEntityPropertyPath = someEntityJoin.get(SomeEntity_.aProperty);
Predicate someEntityPropertyPredicate = cb.equal(someEntityPropertyPath,
            "a property value");
subquery.select(role2Root.get(Role2_.id));
subquery.where(someEntityPropertyPredicate);

In<String> idInSubqueryIds = cb.in(roleIdPath).value(subquery);

query.select(user.get(User_.username));
query.where(idInSubqueryIds);

EntityManager entityManager = ...;
TypedQuery<String> query = entityManager.createQuery(query);
List<String> usernames = query.getResultList();