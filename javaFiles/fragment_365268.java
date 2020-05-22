int year = Integer.parseInt(splitted[0]);
int month = Integer.parseInt(splitted[1]) - 1;
int day = Integer.parseInt(splitted[2].substring(0,2));
int hours = Integer.parseInt(split3[0]);
int minutes = Integer.parseInt(split3[1]);

JSONArray arry = new JSONArray();
Calendar cal = Calendar.getInstance();
cal.set(year, month, day, hours, minutes);
arry.put(cal.getTimeInMillis());
arry.put(c.getDouble(c.getColumnIndexOrThrow("glucose"));

// ...
resultSet.put(arry);