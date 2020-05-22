Calendar d = Calendar.getInstance();
    Calendar begin = Calendar.getInstance();
    Calendar end = Calendar.getInstance();

    begin.set(Calendar.HOUR, 9);
    begin.set(Calendar.MINUTE, 29);
    begin.set(Calendar.AM_PM, Calendar.AM);

    end.set(Calendar.HOUR, 4);
    end.set(Calendar.MINUTE, 01);
    end.set(Calendar.AM_PM, Calendar.PM);

    if (d.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY || d.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
            || (d.after(begin) && d.before(end))) {
        System.out.println("YAY!");
    }