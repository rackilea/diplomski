CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> client = cq.from(Client.class);

        //Pass all conditions to CriteriaBuilder 'and'
        Predicate predicate = cb.and(cb.equal(client.get("firstName"), "Fido"),
                   cb.like(client.get("lastName"), "brown")); 
        cq.where(predicate);

        TypedQuery<Client> q = em.createQuery(cq);
        List<Client> allClients = q.getResultList();