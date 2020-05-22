int diff_hrs = getDiffHours(date,new Date());// pass your date object as startDate and pass current date as your endDate


public int getDiffHours(Date startDate, Date endDate){

  Interval interval = new Interval(startDate.getTime(), endDate.getTime());
  Period period = interval.toPeriod();
  return period.getHours();
}