Date fromDate = null ; // assign reservation start dat
Date toDate = null ; // assign reservation upto
Query query = db.query();
query.constrain(Booking.class);
query.descend ("fromDate").constrain ( fromDate ).greater().equal ().
      and (query.descend ("toDate").constrain (toDate).smaller().equal());
ObjectSet<Booking> objectSet = query.execute();