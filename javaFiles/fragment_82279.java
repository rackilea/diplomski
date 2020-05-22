EventCategory eventCategory = new EventCategory();
eventCategory.setEvent(event);
eventCategory.setCategory(category);
eventCategory.setId(eventCategoryId);

Session session = getSession();
Transaction transaction = session.beginTransaction();
session.save( eventCategory );
transaction.commit();