public String createEvent(String name, String startTime, String endTime) {
    requireAuthorization();
    MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
    data.set("name", name);
    data.set("start_time", startTime);
    data.set("end_time", endTime);
    return graphApi.publish("me", "events", data);
}