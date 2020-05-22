...
SimpleDateFormat dfMin = new SimpleDateFormat("mm");
dfMin.setTimeZone(tz); // Setting timezone
PeriodAxisLabelInfo aperiodaxislabelinfo[] = new PeriodAxisLabelInfo[2];
aperiodaxislabelinfo[0] = new PeriodAxisLabelInfo(
        org.jfree.data.time.Minute.class, dfMin);
SimpleDateFormat dfHour = new SimpleDateFormat("mm");
dfHour.setTimeZone(tz); // Setting timezone
aperiodaxislabelinfo[1] = new PeriodAxisLabelInfo(
        org.jfree.data.time.Hour.class, dfHour);
periodaxis.setLabelInfo(aperiodaxislabelinfo);
...