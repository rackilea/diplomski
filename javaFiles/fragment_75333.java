Calendar calendar = Calendar.getInstance();
calendar.set(Calendar.HOUR_OF_DAY, 0);
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);
Date fromDate = calendar.getTime();

calendar.set(Calendar.HOUR_OF_DAY, 23);
calendar.set(Calendar.MINUTE, 59);
calendar.set(Calendar.SECOND, 59);
Date toDate = calendar.getTime();

criteria.add(Restrictions.between("dateField", fromDate, toDate));