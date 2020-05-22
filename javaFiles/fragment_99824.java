final GsonBuilder builder = new GsonBuilder();
final Gson gson = builder.create();

String jsonObjectString ="{\"menu_fields\":[{\"id\": 22, \"menu_id\": 1, \"field_type_id\": 1, \"c4w_code\": \"1234\", \"field_label\": \"Customer No\", \"field_values\": \"\", \"date_created\": \"2012-09-16 05:11:23\", \"date_modified\": \"2013-11-20 10:33:23\", \"is_required\": 0, \"is_static\": 1, \"field_order\": 1 }, {\"id\": 23, \"menu_id\": 1, \"field_type_id\": 1, \"c4w_code\": \"1234\", \"field_label\": \"Company Name\", \"field_values\": \"\", \"date_created\": \"2012-09-16 05:11:56\", \"date_modified\": \"2013-11-20 10:33:23\", \"is_required\": 1, \"is_static\": 1, \"field_order\": 3 }]}";
try {
    MenuFieldHolder menuFieldHolder= gson.fromJson(jsonObjectString, MenuFieldHolder.class);
    Log.i("TAG", "Result: " + menuFieldHolder.toString());
} catch (Throwable t) {
    t.printStackTrace();
}