package com.ggl.testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeRangeTest {

    private static final SimpleDateFormat inputDateFormat = new SimpleDateFormat(
            "dd-MM-yyyy");

    public static void main(String[] args) {
        TimeRangeTest test = new TimeRangeTest();
        int minutes = test.calculateTotalMinutes("30-11-2015 10:00",
                "02-12-2015 15:00", "07:00", "22:00");
        System.out.println(minutes + " minutes, " + (minutes / 60) + " hours");
    }

    public int calculateTotalMinutes(String startDateTimeString,
            String endDateTimeString, String startTimeString,
            String endTimeString) {
        try {
            List<TimeRange> timeRanges = generateTimeRanges(
                    startDateTimeString, endDateTimeString);
            return calculateTimeRange(timeRanges, startTimeString,
                    endTimeString);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private List<TimeRange> generateTimeRanges(String startDateTimeString,
            String endDateTimeString) throws ParseException {
        Date startDate = inputDateFormat.parse(startDateTimeString.substring(0,
                10));
        Time startTime = new Time(startDateTimeString.substring(11));
        Date endDate = inputDateFormat
                .parse(endDateTimeString.substring(0, 10));
        Time endTime = new Time(endDateTimeString.substring(11));

        List<TimeRange> timeRanges = new ArrayList<>();

        Date currentDate = new Date(startDate.getTime());
        Time currentTime = new Time(startTime);
        Time eodTime = new Time("24:00");

        while (currentDate.compareTo(endDate) < 0) {
            TimeRange timeRange = new TimeRange(currentDate, currentTime,
                    eodTime);
            timeRanges.add(timeRange);
            currentTime = new Time("00:00");
            currentDate = new Date(currentDate.getTime() + 24L * 60L * 60L
                    * 1000L);
        }

        TimeRange timeRange = new TimeRange(currentDate, currentTime, endTime);
        timeRanges.add(timeRange);

        return timeRanges;
    }

    private int calculateTimeRange(List<TimeRange> timeRanges,
            String startTimeString, String endTimeString) {
        int count = 0;

        Time startTime = new Time(startTimeString);
        Time endTime = new Time(endTimeString);

        for (TimeRange timeRange : timeRanges) {
            Time sodTime = new Time(timeRange.getStartTime());
            Time eodTime = new Time(timeRange.getEndTime());
            Time sTime = startTime.max(sodTime);
            Time eTime = endTime.min(eodTime);

            count += eTime.difference(sTime);
        }

        return count;
    }

    public class TimeRange {

        private final SimpleDateFormat inputDateFormat = new SimpleDateFormat(
                "dd-MM-yyyy");

        private final Date date;

        private final Time startTime;
        private final Time endTime;

        public TimeRange(Date date, Time startTime, Time endTime) {
            this.date = date;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Date getDate() {
            return date;
        }

        public Time getStartTime() {
            return startTime;
        }

        public Time getEndTime() {
            return endTime;
        }

        @Override
        public String toString() {
            return inputDateFormat.format(getDate()) + " "
                    + startTime.toString() + " -> " + endTime.toString();
        }

    }

    public class Time {

        private final int minutesPastMidnight;

        public Time(String timeString) {
            int hours = Integer.valueOf(timeString.substring(0, 2));
            int minutes = Integer.valueOf(timeString.substring(3, 5));
            this.minutesPastMidnight = hours * 60 + minutes;
        }

        public Time(Time time) {
            this.minutesPastMidnight = time.getMinutesPastMidnight();
        }

        private int getMinutesPastMidnight() {
            return minutesPastMidnight;
        }

        public int difference(Time time) {
            return this.getMinutesPastMidnight()
                    - time.getMinutesPastMidnight();
        }

        public Time min(Time time) {
            return (difference(time) > 0) ? time : this;
        }

        public Time max(Time time) {
            return (difference(time) > 0) ? this : time;
        }

        @Override
        public String toString() {
            int hours = minutesPastMidnight / 60;
            int minutes = minutesPastMidnight - (hours * 60);
            return String.format("%02d:%02d", hours, minutes);
        }
    }

}