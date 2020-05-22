return new HibernateGridDataSource(session, Foo.class) {
        @Override
        protected void applyAdditionalConstraints(Criteria crit) {
            crit.addOrder(Order.desc("date"));
        }
    };