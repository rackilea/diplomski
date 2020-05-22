public int getActualMinimum(int field) {
        if (field == DAY_OF_MONTH) {
            GregorianCalendar gc = getNormalizedCalendar();
            int year = gc.cdate.getNormalizedYear();
            if (year == gregorianCutoverYear || year == gregorianCutoverYearJulian) {
                long month1 = getFixedDateMonth1(gc.cdate, gc.calsys.getFixedDate(gc.cdate));
                BaseCalendar.Date d = getCalendarDate(month1);
                return d.getDayOfMonth();
            }
        }
        return getMinimum(field);
    }