import java.lang.reflect.Type;

GsonBuilder gsonBuilder = new GsonBuilder();
Gson gson = gsonBuilder.create();

Type type = new TypeToken<List<abc>>() {
            }.getType();

List<abc> abcList = gson.fromJson(confTemplate,
                    type); // confTemplate is your Json object you get from DB

this will get the list of beans. 

for (abc abcData : abcList ) {
 // you can do your stuff
}