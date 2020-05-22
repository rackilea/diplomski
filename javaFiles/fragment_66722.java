public Date getTaskEndTime(Calendar startDate, int hours){
    while (hours > 0){
        int step = 0;
        if(hours > 24) step = 24;
        else step = hours;          
        hours -= step;          
        startDate.add(Calendar.HOUR_OF_DAY, step);          
        int dayOfWeek = startDate.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == Calendar.SATURDAY) hours += 24;
        if(dayOfWeek == Calendar.SUNDAY) hours += 24;
    }
    return startDate.getTime();
}