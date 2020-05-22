public List eventsByDayTest(final String day)
    {
        //function to get events by day (ex all events of friday)

        Query query=db().query();
        query.constrain(Event.class);
        query.descend("Day").constrain(day);
        ObjectSet result=query.execute();
        return result;
    }