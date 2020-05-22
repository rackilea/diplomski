do {
          startCal.add(Calendar.DAY_OF_MONTH, 1);
          if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
          && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
          && !holidays.contains((Integer) startCal.get(Calendar.DAY_OF_YEAR))) {
              ++workDays;
          }
} while (startCal.getTimeInMillis() < endCal.getTimeInMillis());