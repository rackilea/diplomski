StringBuffer buffer = new StringBuffer();

    Calendar date = Calendar.getInstance();
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
    FieldPosition yearPosition = new FieldPosition(DateFormat.YEAR_FIELD);

    StringBuffer format = dateFormat.format(date.getTime(), buffer, yearPosition);
    format.replace(yearPosition.getBeginIndex(), yearPosition.getEndIndex(), String.valueOf(date.get(Calendar.YEAR)));

    System.out.println(format);