List fields = new ArrayList(1);
fields.add("tag")

List contents = new ArrayList(tags.size());
for ( String tag : tags ) {
    contents.add(tag);
}

session.createCriteria(Event.class);
criteria.createCriteria("eventDatas").add(Restrictions.and(Restrictions.in("field", fields), Restrictions.in("content", contents)));