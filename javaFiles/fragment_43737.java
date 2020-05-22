Set<String> models = getHundredsOfModels(); 
if (models.size()>1000) throw new TooManyResultsException(); // Oracle limit

CriteriaBuilder cb          = em.getCriteriaBuilder();
CriteriaQuery<User> cQuery  = cb.createQuery(User.class);
Root<User> user             = cQuery.from(User.class);
List<Predicate> predicates  = new ArrayList<Predicate>();

//  This lines are the trick  ------------------------------------------
Join<User, Car> usersCars   = user.join("cars", JoinType.INNER);
Predicate p                 = usersCars.<String>get("model").in(models);
// ---------------------------------------------------------------------    

predicates.add(p);
cQuery.select(user).where(predicates.toArray(new Predicate[predicates.size()]));