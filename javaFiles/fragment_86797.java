dynamicSchedule = new Schedule<Integer>();
dynamicSchedule.setOwner(this);
dynamicSchedule.setCalendarType(true);
dynamicSchedule.setFirstDayOfWeek(MONDAY);
dynamicSchedule.setTimeUnits(TIME_UNIT_WEEK);
dynamicSchedule.setPeriod(1);       // Repeats every 1 time unit (week)
dynamicSchedule.setGlueIntervals(true);
dynamicSchedule.setDefaultValue(0);     // Default schedule value (0)

// Add intervals for Mon-Fri (day 1-5) from the given start to the end hour with the given shift size
for (int i = 1; i <=5; i++) {
    dynamicSchedule.addInterval(1, // startWeek
                                i, // startDayOfWeek,
                                startHour,  //startHour
                                0, // startMinute
                                0, // startSecond
                                1, // endWeek
                                i, // endDayOfWeek
                                endHour, //endHour
                                0, // endMinute
                                0, // endSecond
                                shiftSize);  //value
}

dynamicSchedule.initialize();   // Needed to 'take' the changes

// Can't do the below: can't change a ResourcePool's capacity definition dynamically
//workers.set_capacityDefinitionType(CapacityDefinitionType.CAPACITY_SCHEDULE);
//workers.set_capacitySchedule(dynamicSchedule);

// Instead we create a chain of dynamic events to change the Resource Pool capacity as per the schedule
create_ShiftChange(dynamicSchedule.getTimeoutToNextValue(), dynamicSchedule.getNextValue());