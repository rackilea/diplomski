mWeekView.setMonthChangeListener(new MonthLoader.MonthChangeListener() {
        @Override
        public List<? extends WeekViewEvent> onMonthChange(int newYear, int newMonth) {

            List<WeekViewEvent> lastone = new ArrayList<WeekViewEvent> ();
            lastone = loadDateFromJson( newYear ,  newMonth);
             events.addAll(lastone);
            ArrayList<WeekViewEvent> matchedEvents = new ArrayList<WeekViewEvent>();
            for (WeekViewEvent event : events) {
                if (eventMatches(event, newYear, newMonth)) {
                    matchedEvents.add(event);
                }
            }
            return matchedEvents;
        }
    } );

}