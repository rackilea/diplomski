HttpEntity getResponseEntity = getResponse.getEntity();
InputStream source = getResponseEntity.getContent();

Gson gson = new Gson();
Reader reader = new InputStreamReader(source);
ScheduleData scheduleData = gson.fromJson(reader, ScheduleData.class);