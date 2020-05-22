ExampleEntity entity = (ExampleEntity) sessionFactory.getCurrentSession().createCriteria(ExampleEntity.class).add(Restrictions.eq("id", 190001L)).uniqueResult();

entity.setState(State.CLOSED);
entity.setVersion(e.getVersion() + 1);

sessionFactory.getCurrentSession().update(entity);