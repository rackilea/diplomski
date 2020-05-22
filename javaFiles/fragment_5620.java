CriteriaQuery<Customer> criteriaQuery = getBuilder().createQuery(Customer.class);
    Root<Customer> customersRoot = criteriaQuery.from(Customer.class);
    Join<Customer, Transactions> transactions = customersRoot.join("transactions");

ParameterExpression param = getBuilder().parameter(int.class, "myParam");
TypedQuery<Customer> query = em.createQuery(criteriaQuery.select(customerRoot).where(getBuilder().equal(transactions.get("statusType"), param)));

// Execute with first parameter value
query.setParameter("myParam", 1003);
List<Customer> customerList = (List<Customer>) query.getResultList();