public List<User> getAllExceptThese(Collection<String> emails) {
            checkArgument(!emails.isEmpty());

            String queryStr = "FROM User u WHERE u.email NOT IN (:excludedEmails)";

            Query query = entityManager.createQuery(queryStr);
            query.setParameter("excludedEmails", emails);
            return (List<User>)query.getResultList();
  }