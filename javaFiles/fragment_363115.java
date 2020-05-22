public ArrayList<String> getTimeSlot(int slotMinute, strFromTime, strToTime, exceptTime) {
    int fromHour, fromMinute, toHour, toMinute;

    fromHour = Integer.parseInt(strFromTime.split(":")[0]);
    fromMinute = Integer.parseInt(strFromTime.split(":")[1]);

    toHour = Integer.parseInt(strToTime.split(":")[0]);
    toMinute = Integer.parseInt(strToTime.split(":")[1]);

    long slot = slotMinute * 60 * 1000;
    Calendar calendar2 = Calendar.getInstance();
    calendar2.set(Calendar.HOUR_OF_DAY, fromHour);
    calendar2.set(Calendar.MINUTE, fromMinute);

    long currentTime = calendar2.getTimeInMillis();
    Calendar calendar1 = Calendar.getInstance();
    calendar1.set(Calendar.HOUR_OF_DAY, toHour);
    calendar1.set(Calendar.MINUTE, toMinute);

    long endTime = calendar1.getTimeInMillis();

    ArrayList<String> timeSlot = new ArrayList<String>();

    while (currentTime < endTime) {
        if (availableDatesItem.getExcept() == null) {
            timeSlot.add(sdfTime.format(new Date(currentTime)));
            currentTime = currentTime + slot;
        } else {
            for (int i = 0; i < exceptTime.size(); i++) {

                int exceptFromHour, exceptFromMinute, exceptToHour, exceptToMinute;

                exceptFromHour = Integer.parseInt(exceptTime.get(i).getFrom().split(":")[0]);
                exceptFromMinute = Integer.parseInt(exceptTime.get(i).getFrom().split(":")[1]);

                exceptToHour = Integer.parseInt(exceptTime.get(i).getTo().split(":")[0]);
                exceptToMinute = Integer.parseInt(exceptTime.get(i).getTo().split(":")[1]);

                Calendar cal2 = Calendar.getInstance();
                cal2.set(Calendar.HOUR_OF_DAY, exceptFromHour);
                cal2.set(Calendar.MINUTE, exceptFromMinute);

                long exceptFrom = cal2.getTimeInMillis();
                Calendar cal1 = Calendar.getInstance();
                cal1.set(Calendar.HOUR_OF_DAY, exceptToHour);
                cal1.set(Calendar.MINUTE, exceptToMinute);

                long exceptTo = cal1.getTimeInMillis();
                if (currentTime < exceptFrom) {
                    timeSlot.add(sdfTime.format(new Date(currentTime)));
                    currentTime = currentTime + slot;
                } else if (currentTime > exceptFrom && currentTime > exceptTo) {
                    timeSlot.add(sdfTime.format(new Date(currentTime)));
                    currentTime = currentTime + slot;
                } else {
                    currentTime = currentTime + slot;
                }
            }
        }
    }
    return timeSlot;
}