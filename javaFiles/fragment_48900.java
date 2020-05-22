GregorianCalendar c = new GregorianCalendar(2013, 0, 1);
    while (c.get(Calendar.YEAR) == 2013) {
        if (!(c.get(Calendar.DAY_OF_MONTH) == 13 &&  c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)) {
            System.out.println(c.getTime());
        }
        c.add(Calendar.DAY_OF_YEAR, 1);
    }