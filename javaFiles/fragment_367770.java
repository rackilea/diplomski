private boolean isNewDowntimeValid(Downtime newDowntime, List<Downtime> createdDowntimes) {
    // the start of the new downtime
    ZonedDateTime newStartTime = newDowntime.getDowntimeFrom();

    for (Downtime downtime : createdDowntimes) {
        ZonedDateTime downtimeStart = downtime.getDowntimeFrom();
        ZonedDateTime downtimeEnd = downtime.getDowntimeTo();

        if (newStartTime.equals(downtimeStart)) {
            // start date of new downtime already exists
            return false;
        }

        // start date of new downtime is in the existent downtime
        // (existent startDate < new startDate and new startDate < existent endDate)
        if (downtimeStart.isBefore(newStartTime) && newStartTime.isBefore(downtimeEnd)) {
            return false;
        }
    }

    // no invalid cases found, it's valid
    return true;
}