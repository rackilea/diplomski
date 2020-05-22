Root<Center> center = cq.from(Center.class);
Join<Center, HoursOfOperation> hoursOfOperation = center.join(Center_.hoursOfOperations);
Join<Center, State> state = center.join(Center_.stateId);
Path<HoursOfOperationPK> hoursOfOperationPK = hoursOfOperation.get(HoursOfOperation_.hoursOfOperationPK);
cq.where(cb.equal(center.get(Center_.city), "cityName"));
cq.orderBy(cb.asc(hoursOfOperationPK.get(HoursOfOperationPK_.weekdayNumber)));
TypedQuery<Center> query = em.createQuery(cq);