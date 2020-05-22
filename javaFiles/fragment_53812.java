Calendar dateCal = Calendar.getInstance();
  dateCal.set(Calendar.MONTH, month);
  dateCal.set(Calendar.YEAR, year);
  dateCal.set(Calendar.HOUR_OF_DAY, 0);
  dateCal.set(Calendar.MINUTE, 0);
  dateCal.set(Calendar.SECOND, 0);
  dateCal.set(Calendar.MILLISECOND, 0);
  Date startDate = dateCal.getTime();

  dateCal.add(Calendar.MONTH, 1)
  dateCal.add(Calendar.MILLISECOND, -1);
  Date endDate = dateCal.getTime();