private static DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm");

public static Timestamp convert(String str) {
    try {
        Date date = dateFormat.parse(str);
        return new Timestamp(date.getTime());
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
}

public List<Record> getRecord(String starttime, String endtime) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    map.put("startTime", convert(startTime));
    map.put("endTime", convert(endTime));
    List<APIServerRecord> listRes=apiServerRecordMapper.getAPIServerRecord(map);
    return listRes;
}