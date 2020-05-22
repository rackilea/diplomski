Calendar cal = mock.randomBeginHour();
consoApp.setBeginHour(cal);
Calendar cal2 = Calendar.getInstance();
cal2.setTime(cal.getTime());
cal2.add(Calendar.MINUTE, +5);
cal2.add(Calendar.SECOND, +10);
consoApp.setEndHour(cal2);
dao.addConsoAppel(consoApp);