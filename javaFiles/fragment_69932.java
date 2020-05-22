public void createWeeks(JSONArray TargetDays){
    int helper, targetDayPos, curDayPos;
    JSONArray dateContainer = new JSONArray();
    Date currentDate = new Date();
    Calendar c = Calendar.getInstance();
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
    Utilities dayConverter = new Utilities(getApplicationContext());

    try {
        for(int i=0 ; i<TargetDays.length() ; i++){

            c.setTime(currentDate);
            targetDayPos = dayConverter.getDayPosition(TargetDays.getString(i));
            curDayPos = dayConverter.getCalenderDayPosition(dayOfWeek);
            if (curDayPos > targetDayPos) {
                helper = curDayPos - targetDayPos;
                c.add(Calendar.DATE, -helper);
            }
            else if(targetDayPos > curDayPos) {
                helper = targetDayPos - curDayPos;
                c.add(Calendar.DATE, helper);
            }
            dateContainer.put(dateFormat.format(c));

        }
        weekDayList.put("days",TargetDays);
        weekDayList.put("dates", dateContainer);


    } catch (JSONException e) {
        e.printStackTrace();
    }
}