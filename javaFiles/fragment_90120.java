Subquery<Long> sq = query.subquery(Long.class);
Root<DeadlineDate> deadlineDate = query.from(DeadlineDate.class);
Root<DeadlineDate> deadlineDateSQ = sq.from(DeadlineDate.class);
Path<Deadline> deadline = deadlineDate.get("deadline");
Path<Deadline> deadlineSQ = deadlineDateSQ.get("deadline");
sq.select(criteriaBuilder.max(deadlineSQ.<Long>get("id")));
sq.groupBy(deadlineSQ);
... //create the list of other predicates
sq.where(predicateListSQ);
query.select(deadline);
Predicate predicate1 = criteriaBuilder.in(deadlineDate.get("id")).value(sq);
Predicate predicate2 = criteriaBuilder.lessThan(deadlineDate.<Date>get("date"), date);
query.where(criteriaBuilder.and(predicate1, predicate2));