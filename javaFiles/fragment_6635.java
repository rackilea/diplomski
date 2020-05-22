ClassB cb = new ClassB();
cb.setId("50866d45004d84852b16a8b8");

Criteria criteria = Criteria.where("classBId").is(classBObject);
Query query = new Query();
query.addCriteria(criteria);