public static class CheckInterfaceDeserializer implements JsonDeserializer<CheckInterface>{

    @Override
    public CheckInterface deserialize(JsonElement json, Type typeOfT,
                       JsonDeserializationContext context) throws JsonParseException {
        JsonObject jObject = (JsonObject) json;
        JsonElement typeObj = jObject.get("TypeName");

        if(typeObj!= null ){
            String typeVal = typeObj.getAsString();

            switch (typeVal){
                case "CheckSpecificDday":
                   return context.deserialize(json, CheckSpecificDday.class);
                case "CheckEveryDayDday":
                    return context.deserialize(json, CheckEveryDayDday.class);
                case "CheckEveryDdayOfWeek":
                    return context.deserialize(json, CheckEveryDdayOfWeek.class);
                case "CheckEveryMonthSpecificDday":
                    return context.deserialize(json, CheckEveryMonthSpecificDday.class);
                case "CheckEveryYearWeek":
                    return context.deserialize(json, CheckEveryYearWeek.class);
            }
        }

        return null;
    }
}