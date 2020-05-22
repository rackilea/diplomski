public void addApplyDay(Day day,TimeRanges trs) {
    if (! _applyCalendar.containsKey(day)) { // << use containsKey
        _applyCalendar.put(day, trs);
    } else {
        for ( TimeRange t : trs) {
            _applyCalendar.get(day).add(t);
        }
    }

}