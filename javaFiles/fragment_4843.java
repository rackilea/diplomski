Criteria idQuery = session.createCriteria(Story.class);
idQuery.add(Restrictions.ge("id", 2));
idQuery.setProjection(Projections.min("id"));
int returnedId = criteria.uniqueResult();

Criteria storyQuery = session.createCriteria(Story.class);
storyQuery.add(Restrictions.idEq(returnedId);
Story story = (Story) storyQuery.uniqueResult();
return story;