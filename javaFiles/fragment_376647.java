public List<Service> findAllWithPrice() {
        NativeQuery<Service> query = this.getCurrentSession().createSQLQuery("select s.*, (select ps.price from priceServices ps where ps.idService = s.id order by ps.dateRegister DESC limit 1) as currentPrice from service s");
        query.addEntity( Service.class );

        return query.getResultList();
    }