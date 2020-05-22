Predicate wantedToBePresentTags = cb.lower(rTag.<String>get("name")).in(cb.parameter(List.class, "tagList"));

Subquery sq = criteriaQuery.subquery(TestExecution.class);
Root sqRoot = sq.from(TestExecution.class);
Join<TestExecution, Tag> sqTag = sqRoot.joinCollection("testExecutionTags").join("tag");
sq.select(sqRoot.get("id"));
sq.where(cb.lower(sqTag.<String>get("name")).in(cb.parameter(List.class, "excludedTagList")));

Predicate excludedTags = cb.not(rExec.get("id").in(sq));

...
criteriaQuery.where(cb.and(wantedToBePresentTags, excludedTags));