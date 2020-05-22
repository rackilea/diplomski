Date dateStart;
Date dateEnd;
int diff = (int) (dateEnd.getTime() - dateStart.getTime());
Date randomDate = new Date(dateStart.getTime()
      + new Random(System.currentTimeMillis()).nextInt(diff));
Calendar then = Calendar.getInstance();
then.setTime(randomDate);