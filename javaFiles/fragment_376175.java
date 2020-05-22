Query q = session.createQuery("select s "
            + "from Service s "
            + "join s.productService as ps "
            + "join s.type as t "
            + "where s.duration = :durationId "
            + "and ps.id.product.id = :productId "
            + "and t.priority <= :priorityValue "
            + "order by t.priority desc");
    q.setLong("durationId", durationId);
    q.setInteger("priorityValue", priorityValue);
    q.setLong("productId", productId);

    return (Service) q.setMaxResults(1).uniqueResult();