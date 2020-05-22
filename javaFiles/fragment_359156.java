Criteria c = session.createCriteria(Document.class, "document");
c.createAlias("document.recipients", "recipient");
c.add(Restrictions.in("recipient.class", Arrays.asList(SubClass1.class, 
                                                       SubClass2.class,
                                                       SubClass3.class)));
c.add(Restrictions.eq("recipient.name", theName));