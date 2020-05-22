String input = "{ \"maj:min\": \"8:80\" }";
GsonBuilder gsonBuilder = new GsonBuilder();
gsonBuilder.registerTypeAdapter(CustomHour.class, new CustomHourDeserializer());
Gson gson = gsonBuilder.create();
Data data = gson.fromJson(input, Data.class);
System.out.println("min : " + data.hour.min + " | max : " + data.hour.maj);