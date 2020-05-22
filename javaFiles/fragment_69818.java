for (int i = 0; i < timetable.length(); i++) {
    JSONObject heroObject = timetable.getJSONObject(i);
    JSONObject timeObject = timetableTime.getJSONObject(i);

    mondayHero mon = new mondayHero(
        heroObject.getString("faculty__first_name"),
        heroObject.getString("subject__name"),
        heroObject.getString("faculty__first_name"),
        timeObject);
    Log.d(TAG,"mon-->"+mon);
    mondayList.add(mon);
}