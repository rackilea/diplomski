Date computedStartDate = new DateTime(startdate).minusDay(6).toDate();
Date computedEndDate = new DateTime(endDate).plusDay(6).toDate();
...
// you create your query
//...
//you set these dates
 query.setParameter("computedStartDate",computedStartDate);
 query.setParameter("computedEndDate",computedEndDate);
// you execute your query