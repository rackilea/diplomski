Calendar cre_calendar = new GregorianCalendar((2013), (1), 11);
        Calendar exp_calendar = new GregorianCalendar((2013), (1), 19);
        Calendar maxDays = new GregorianCalendar(((2013)), (12), 31);

        if (exp_calendar.get(Calendar.DAY_OF_YEAR) < cre_calendar
                .get(Calendar.DAY_OF_YEAR)) {
            System.out
                    .println((exp_calendar.get(Calendar.DAY_OF_YEAR) + maxDays
                            .get(Calendar.DAY_OF_YEAR))
                            - cre_calendar.get(Calendar.DAY_OF_YEAR));
        } else {
            System.out.println((exp_calendar.get(Calendar.DAY_OF_YEAR))
                    - cre_calendar.get(Calendar.DAY_OF_YEAR));
        }