final DetachedCriteria q = DetachedCriteria.forClass(Kitten.class)
            .createAlias("mother", "c")
            .add(Restrictions.like("name", "name_of_a_kitten"))
            .setProjection(Projections.property("c.id"));

    final List<Cat> cats =  session.createCriteria(Cat.class)
            .add(Property.forName("id").in(q)).list();  //not possible order by Kitten attributes