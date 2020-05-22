Calendar date1 = Calendar.getInstance();
date1.set(2014, 05, 12);

while (date1.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
    date1.add(Calendar.DATE, 1);
}

System.out.println(date1.getTime());