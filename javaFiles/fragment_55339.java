while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()) {
    if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.FRIDAY &&
        startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {

        workDays++;
    }

    startCal.add(Calendar.DAY_OF_MONTH, 1);
}