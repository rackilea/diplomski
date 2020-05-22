/**
     *
     * @param c1 from
     * @param c2 to
     * @return amount of days between from and to
     */
    public int diff(Calendar c1, Calendar c2) {
        int years = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        if (years == 0) {
            return c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
        } else {
            Calendar endOfYear =  Calendar.getInstance();
            endOfYear.set(Calendar.YEAR, c1.get(Calendar.YEAR));
            endOfYear.set(Calendar.MONTH, 11);
            endOfYear.set(Calendar.DAY_OF_MONTH, 31);
            int days = endOfYear.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
            for (int i=1;i <years;i++) {
                endOfYear.add(Calendar.YEAR, 1);
                days += endOfYear.get(Calendar.DAY_OF_YEAR);
            }
            days += c2.get(Calendar.DAY_OF_YEAR);
            return days;
        }
    }