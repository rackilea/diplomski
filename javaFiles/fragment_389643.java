final Gson gson = new GsonBuilder().registerTypeAdapter(
        new TypeToken<EnumMap<Country, String>>() {
        }.getType(),
        new EnumMapInstanceCreator<Country, String>(Country.class))
        .create();

final Map<Country, String> enumMap = new EnumMap<Country, String>(
        Country.class);
enumMap.put(Country.Malaysia, "RM");
enumMap.put(Country.UnitedStates, "USD");
String string = gson.toJson(enumMap);
System.out.println("toJSon : " + string);

final Map<Country, String> reverseEnumMap = gson.fromJson(string,
        new TypeToken<EnumMap<Country, String>>() {
        }.getType());
System.out.println("fromJSon (Class): " + reverseEnumMap.getClass());
System.out.println("fromJSon : " + reverseEnumMap);