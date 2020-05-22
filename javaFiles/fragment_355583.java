DetachedCriteria subquery = DetachedCriteria.forClass(ItemAssociation.class)
                    .add(Restrictions.eq("item.id", itemId))
                    .setProjection(Projections.property("groupId"));

Criteria query = session.createCriteria(ItemAssociation.class)
                    .add(Property.forName("groupId").in(subquery))
                    .add(Restrictions.not(Restrictions.eq("item.id", itemId)));