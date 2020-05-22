//Get criteria builder
CriteriaBuilder cb = em.getCriteriaBuilder();
//Create the CriteriaQuery for Person object
CriteriaQuery<Person> query = cb.createQuery(Person.class);

//From clause
Root<Person> personRoot = query.from(Person.class);

//Where clause
query.where(
    cb.function(
        "CONTAINS", Boolean.class, 
        //assuming 'lastName' is the property on the Person Java object that is mapped to the last_name column on the Person table.
        personRoot.<String>get("lastName"), 
        //Add a named parameter called containsCondition
        cb.parameter(String.class, "containsCondition")));

TypedQuery<Person> tq = em.createQuery(query);
tq.setParameter("containsCondition", "%näh%");
List<Person> people = tq.getResultList();