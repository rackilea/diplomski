Calendar vCal = Calendar.getInstance();
vCal.add(Calendar.WEEK_OF_YEAR, -2); //two weeks ago
vCal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY); //friday

int vDay = vCal.get(Calendar.DAY_OF_MONTH); //day
int vMonth = vCal.get(Calendar.MONTH); //month
int vYear = vCal.get(Calendar.YEAR); //year

Date d = vCal.getTime(); //full date