class HibernateLayer {
    public List<Foo> findFoo(String someCriteria) {
        Query q = new Query("from Foo f where f.someCriteria = :1");
        //...
    }

    public List<Foo> findFooWithBars(String someCriteria) {
        Query q = new Query("from Foo f left join fetch Bar b where f.someCriteria = :1");
        //...
    }